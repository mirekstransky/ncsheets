package cz.ncsheets.lavat.service.rest;

import cz.ncsheets.lavat.entity.*;
import cz.ncsheets.lavat.exception.*;
import cz.ncsheets.lavat.repository.HolderRepository;
import cz.ncsheets.lavat.repository.HoldersizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
        checkIDnull(holder);

        Optional<Holder> newHolder = holderRepository.findComponentByName(holder.getName());
        Holdersize holdersize = holdersizeServiceREST.saveComponent(holder.getHolderSize());

        if (newHolder.isPresent()){
            holder.setId(newHolder.get().getId());
            holder.setHolderSize(holdersize);
            return holderRepository.save(holder);
        }else{
            holder.setHolderSize(holdersize);
            return holderRepository.save(holder);
        }
    }
    @Override
    public Holder updateComponent(Holder holder, Long id) {
        Holder holder_copy = unwrapComponent(holderRepository.findById(id),id);

        Holdersize holdersize = holdersizeServiceREST.updateComponent(
                holder.getHolderSize(),holder.getHolderSize().getId());
        holder.setHolderSize(holdersize);
        holder.setId(id);

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
        if (entity.isPresent()) return entity.get();
        if (id > 0){
            throw new NotFoundException("Holder", id);
        }else {
            throw new BadArgumentType(id);
        }
    }
    private void checkIDnull(Holder holder){
        if (!Objects.isNull(holder.getId())) {
            throw new ObjectIDisNotNull("HOLDER");
        }
    }
}
