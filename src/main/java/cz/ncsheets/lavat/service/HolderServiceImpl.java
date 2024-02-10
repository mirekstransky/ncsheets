package cz.ncsheets.lavat.service;

import cz.ncsheets.lavat.entity.*;
import cz.ncsheets.lavat.entity.filter.HolderForm;
import cz.ncsheets.lavat.exception.*;
import cz.ncsheets.lavat.repository.HolderRepository;
import cz.ncsheets.lavat.repository.HoldersizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class HolderServiceImpl implements HolderService {


////////////////////////////
//    NENI DODELANO     ////
////////////////////////////



    HolderRepository holderRepository;
    HoldersizeRepository holdersizeRepository;
    HoldersizeService holdersizeService;

    @Override
    public List<Holder> getComponents(){
        return (List<Holder>)holderRepository.findAll();
    }

    @Override
    public Page<Holder> getPageAll(Pageable pageable) {
        return holderRepository.findAll(pageable);
    }

    @Override
    public Page<Holder> findPageByHolderForm(HolderForm form, Pageable pageable) {
        return holderRepository.findPageByHolderForm(form,pageable);
    }
    @Override
    public Holder getComponent(Long id) {
        Optional<Holder> holderOptional = holderRepository.findById(id);
        return unwrapComponent(holderOptional,id);
    }
    @Override
    public Holder saveComponent(Holder holder) {
        checkIDnull(holder);

        Optional<Holder> newHolder = holderRepository.findComponentByName(holder.getName());
        Holdersize holdersize = holdersizeService.saveComponent(holder.getHolderSize());

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

        Holdersize holdersize = holdersizeService.updateComponent(
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
