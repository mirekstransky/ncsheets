package cz.ncsheets.lavat.service.rest;

import cz.ncsheets.lavat.entity.Adapter;
import cz.ncsheets.lavat.exception.*;
import cz.ncsheets.lavat.repository.AdapterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AdapterServiceRESTImpl implements AdapterServiceREST {


    AdapterRepository adapterRepository;

    @Override
    public List<Adapter> getComponents(){
        return (List<Adapter>)adapterRepository.findAll();}
    @Override
    public Adapter getComponent(Long id) {
        Optional<Adapter> adapterOptional = adapterRepository.findById(id);
        return unwrapAdapter(adapterOptional,id);
    }
    @Override
    public Adapter saveComponent(Adapter adapter) {
        validateErrors(adapter);
//        if (findComponent(adapter)) throw new DuplicateObjectException();
        return adapterRepository.save(adapter);
    }
    @Override
    public Adapter updateComponent(Adapter adapter, Long id) {
        validateErrors(adapter);
        Adapter adapter_copy = unwrapAdapter(adapterRepository.findById(id),id);
        adapter.setId(id);
        return adapterRepository.save(adapter);
    }
    @Override
    public void deleteComponent(Long id) {
      Optional<Adapter> adapter = adapterRepository.findById(id);
      Adapter adapter_copy = unwrapAdapter(adapter,id);
      adapterRepository.deleteById(id);
    }
    @Override
    public void deleteAll() {
        adapterRepository.deleteAll();}
    //#############################################################################################
    private Adapter unwrapAdapter(Optional<Adapter> entity, Long id) {
        if (entity.isPresent()){
            return entity.get();
        }
        if (id > 0){
            throw new NotFoundException("Adapter", id);
        }else {
            throw new BadArgumentType(id);
        }
    }

    private void validateErrors(Adapter adapter){
        if (!Objects.isNull(adapter.getId())) {
            throw new ObjectIDisNotNull();
        }
    }

}
