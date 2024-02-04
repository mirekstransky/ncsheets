package cz.ncsheets.lavat.service.rest;

import cz.ncsheets.lavat.entity.Holder;
import cz.ncsheets.lavat.entity.Holdersize;
import cz.ncsheets.lavat.entity.Tooltype;
import cz.ncsheets.lavat.exception.BadArgumentType;
import cz.ncsheets.lavat.exception.NotFoundException;
import cz.ncsheets.lavat.exception.ObjectIDisNotNull;
import cz.ncsheets.lavat.repository.HoldersizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class HoldersizeServiceRESTImpl implements HoldersizeServiceREST{

    HoldersizeRepository holdersizeRepository;

    @Override
    public List<Holdersize> getComponents(){
        return (List<Holdersize>)holdersizeRepository.findAll();}
    @Override
    public Holdersize getComponent(Long id) {
        Optional<Holdersize> holdersizeOptional = holdersizeRepository.findById(id);
        return unwrapComponent(holdersizeOptional,id);
    }
    @Override
    public Holdersize saveComponent(Holdersize holdersize) {
        checkIDnull(holdersize);
        Optional<Holdersize> newHoldersize = holdersizeRepository.findComponentByName(holdersize.getName());
        if (newHoldersize.isPresent()){
            holdersize.setId(newHoldersize.get().getId());
            return holdersizeRepository.save(holdersize);
        }else{
            return holdersizeRepository.save(holdersize);
        }
    }
    @Override
    public Holdersize updateComponent(Holdersize holdersize, Long id) {
        Holdersize holdersize_copy = unwrapComponent(holdersizeRepository.findById(id),id);
        holdersize.setId(id);
        return holdersizeRepository.save(holdersize);
    }
    @Override
    public void deleteComponent(Long id) {
        Optional<Holdersize> holdersize = holdersizeRepository.findById(id);
        Holdersize holdersize_copy = unwrapComponent(holdersize,id);
        holdersizeRepository.deleteById(id);
    }
    @Override
    public void deleteAll() {
        holdersizeRepository.deleteAll();}

    @Override
    public List<Holdersize> saveAllComponents(List<Holdersize> holdersizeList){
        return holdersizeRepository.saveAll(holdersizeList);
    }
    //#############################################################################################
    private Holdersize unwrapComponent(Optional<Holdersize> entity, Long id) {
        if (entity.isPresent()){
            return entity.get();
        }
        if (id > 0){
            throw new NotFoundException("Holdersize", id);
        }else {
            throw new BadArgumentType(id);
        }
    }
    private void checkIDnull(Holdersize holdersize){
        if (!Objects.isNull(holdersize.getId())){
            throw new ObjectIDisNotNull("HOLDERSIZE");
        }
    }
}
