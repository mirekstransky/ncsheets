package cz.ncsheets.lavat.service.rest;

import cz.ncsheets.lavat.entity.Adapter;
import cz.ncsheets.lavat.exception.*;
import cz.ncsheets.lavat.repository.AdapterRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public List<Adapter> getAdapters(){
        return (List<Adapter>)adapterRepository.findAll();}
    @Override
    public Adapter getAdapter(Long id) {
        Optional<Adapter> adapterOptional = adapterRepository.findById(id);
        return unwrapAdapter(adapterOptional,id);
    }
    @Override
    public Adapter saveAdapter(Adapter adapter, BindingResult bindingResult) {
        validateErrors(adapter,bindingResult);
        if (unwrapDuplicate(adapter)) throw new DuplicateObjectException();
        return adapterRepository.save(adapter);
    }
    @Override
    public Adapter updateAdapter(Adapter adapter, Long id) {
        validateErrors(adapter);
        Adapter adapter_copy = unwrapAdapter(adapterRepository.findById(id),id);
        adapter.setId(id);
        return adapterRepository.save(adapter);
    }
    @Override
    public void deleteAdapter(Long id) {
      Optional<Adapter> adapter = adapterRepository.findById(id);
      Adapter adapter_copy = unwrapAdapter(adapter,id);
      adapterRepository.deleteById(id);
    }
    @Override
    public List<Adapter> addBatch(List<Adapter> adapters, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            throw new ObjectValidationFailedException();
        }
        Objects.requireNonNull(adapters);

        for (int i = 0; i < adapters.size(); i++) {
            Objects.requireNonNull(adapters.get(i));
            validateErrors(adapters.get(i));
            if (unwrapDuplicate(adapters.get(i))){
                throw new DuplicateObjectException(i);
            }
            for (int j = 0; j < i; j++) {
                if (adapters.get(j).equals(adapters.get(i))){
                    throw new DuplicateObjectException(i+1);
                }
            }
        }
        return adapterRepository.saveAll(adapters);
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
    private boolean unwrapDuplicate(Adapter adapter){
        Optional<Adapter> adapterOptional = adapterRepository.findDuplicate(adapter.getName()
                ,adapter.getDiameter(),adapter.getLength());
        if (adapterOptional.isPresent()){
            return true;
        }else{
            return false;
        }
    }
    private void validateErrors(Adapter adapter, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ObjectValidationFailedException();
        }
        validateErrors(adapter);
    }
    private void validateErrors(Adapter adapter){
        if (!Objects.isNull(adapter.getId())) {
            throw new ObjectIDisNotNull();
        }
    }

}
