package cz.ncsheets.lavat.service;

import cz.ncsheets.lavat.entity.Adapter;
import cz.ncsheets.lavat.exception.*;
import cz.ncsheets.lavat.repository.AdapterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AdapterServiceImpl implements AdapterService {


    AdapterRepository adapterRepository;

    @Override
    public List<Adapter> getComponents(){
        return (List<Adapter>)adapterRepository.findAll();}
    @Override
    public Adapter getComponent(Long id) {
        Optional<Adapter> adapterOptional = adapterRepository.findById(id);
        return unwrapComponent(adapterOptional,id);
    }
    @Override
    public Adapter saveComponent(Adapter adapter) {
        checkIDnull(adapter);
        Optional<Adapter> newAdapter = adapterRepository.findComponentByName(adapter.getName());
        if (newAdapter.isPresent()){
            adapter.setId(newAdapter.get().getId());
            return adapterRepository.save(adapter);
        }else{
            return adapterRepository.save(adapter);
        }
    }
    @Override
    public Adapter updateComponent(Adapter adapter, Long id) {
        Adapter adapter_copy = unwrapComponent(adapterRepository.findById(id),id);
        adapter.setId(id);
        return adapterRepository.save(adapter);
    }
    @Override
    public void deleteComponent(Long id) {
      Optional<Adapter> adapter = adapterRepository.findById(id);
      Adapter adapter_copy = unwrapComponent(adapter,id);
      adapterRepository.deleteById(id);
    }
    @Override
    public void deleteAll() {
        adapterRepository.deleteAll();}
    //#############################################################################################
    private Adapter unwrapComponent(Optional<Adapter> entity, Long id) {
        if (entity.isPresent()){
            return entity.get();
        }
        if (id > 0){
            throw new NotFoundException("ADAPTER", id);
        }else {
            throw new BadArgumentType(id);
        }
    }
    private void checkIDnull(Adapter adapter){
        if (!Objects.isNull(adapter.getId())){
            throw new ObjectIDisNotNull("ADAPTER");
        }
    }


}
