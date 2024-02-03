package cz.ncsheets.lavat.service.rest;

import cz.ncsheets.lavat.entity.Adapter;
import cz.ncsheets.lavat.entity.Holder;
import cz.ncsheets.lavat.entity.Holdersize;
import cz.ncsheets.lavat.exception.*;
import cz.ncsheets.lavat.repository.HolderRepository;
import cz.ncsheets.lavat.repository.HoldersizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class HolderServiceRESTImpl implements HolderServiceREST {


////////////////////////////
//    NENI DODELANO     ////
////////////////////////////



    HolderRepository holderRepository;
    HoldersizeRepository holdersizeRepository;
    HoldersizeServiceREST holdersizeServiceREST;

    @Override
    public List<Holder> getComponents(){
        return (List<Holder>)holderRepository.findAll();}
    @Override
    public Holder getComponent(Long id) {
        Optional<Holder> holderOptional = holderRepository.findById(id);
        return unwrapComponent(holderOptional,id);
    }
    @Override
    public Holder saveComponent(Holder holder) {
        validateErrors(holder);
        Holdersize holdersize = saveHoldersize(holder);
        holder.getHolderSize().setId(holdersize.getId());
        return holderRepository.save(holder);
    }
    @Override
    public Holder updateComponent(Holder holder, Long id) {
        validateErrors(holder);
        Holder holder_copy = unwrapComponent(holderRepository.findById(id),id);
        holder.setId(id);
        Holdersize holdersize = saveHoldersize(holder);
        holder.getHolderSize().setId(holdersize.getId());
        return holderRepository.save(holder);
    }
    @Override
    public void deleteComponent(Long id) {
      Optional<Holder> holder = holderRepository.findById(id);
      Holder holder_copy = unwrapComponent(holder,id);
        holderRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        holderRepository.deleteAll();}
    //#############################################################################################
    private Holder unwrapComponent(Optional<Holder> entity, Long id) {
        if (entity.isPresent()){
            return entity.get();
        }
        if (id > 0){
            throw new NotFoundException("Holder", id);
        }else {
            throw new BadArgumentType(id);
        }
    }
    private boolean unwrapDuplicate(Holder holder){
        Optional<Adapter> adapterOptional = holderRepository.findComponentByName(holder.getName());
        if (adapterOptional.isPresent()){
            return true;
        }else{
            return false;
        }
    }
    private void validateErrors(Holder holder){
        if (!Objects.isNull(holder.getId())) {
            throw new ObjectIDisNotNull();
        }
    }
    private Holdersize saveHoldersize(Holder holder){
        if (!Objects.isNull(holder.getHolderSize().getId())) {
            throw new ObjectIDisNotNull();
        }
        Optional<Holdersize> holdersize = holdersizeRepository.
                findComponentByName(holder.getHolderSize().getName());
        if (!holdersize.isPresent()){
            Holdersize holdersize_new = new Holdersize();
            holdersize_new.setName(holder.getHolderSize().getName());
            holdersizeServiceREST.saveComponent(holdersize_new);
            return holdersize_new;
        }else{
            return holdersize.get();
        }
    }
}
