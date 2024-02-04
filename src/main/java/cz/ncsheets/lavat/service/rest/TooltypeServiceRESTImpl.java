package cz.ncsheets.lavat.service.rest;

import cz.ncsheets.lavat.entity.Adapter;
import cz.ncsheets.lavat.entity.Holdersize;
import cz.ncsheets.lavat.entity.Tool;
import cz.ncsheets.lavat.entity.Tooltype;
import cz.ncsheets.lavat.exception.BadArgumentType;
import cz.ncsheets.lavat.exception.NotFoundException;
import cz.ncsheets.lavat.exception.ObjectIDisNotNull;
import cz.ncsheets.lavat.repository.TooltypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TooltypeServiceRESTImpl implements TooltypeServiceREST{

    TooltypeRepository tooltypeRepository;

    @Override
    public List<Tooltype> getComponents(){
        return (List<Tooltype>)tooltypeRepository.findAll();}
    @Override
    public Tooltype getComponent(Long id) {
        Optional<Tooltype> tooltypeOptional = tooltypeRepository.findById(id);
        return unwrapComponent(tooltypeOptional,id);
    }
    @Override
    public Tooltype saveComponent(Tooltype tooltype) {
        checkIDnull(tooltype);
        Optional<Tooltype> newTooltype = tooltypeRepository.findComponentByName(tooltype.getName());
        if (newTooltype.isPresent()){
            tooltype.setId(newTooltype.get().getId());
            return tooltypeRepository.save(tooltype);
        }else{
            return tooltypeRepository.save(tooltype);
        }
    }
    @Override
    public Tooltype updateComponent(Tooltype tooltype, Long id) {
        Tooltype tooltype_copy = unwrapComponent(tooltypeRepository.findById(id),id);
        tooltype.setId(id);
        return tooltypeRepository.save(tooltype);
    }
    @Override
    public void deleteComponent(Long id) {
        Optional<Tooltype> tooltype = tooltypeRepository.findById(id);
        Tooltype tooltype_copy = unwrapComponent(tooltype,id);
        tooltypeRepository.deleteById(id);
    }
    @Override
    public void deleteAll() {
        tooltypeRepository.deleteAll();}
    //#############################################################################################
    private Tooltype unwrapComponent(Optional<Tooltype> entity, Long id) {
        if (entity.isPresent()){
            return entity.get();
        }
        if (id > 0){
            throw new NotFoundException("Tooltype", id);
        }else {
            throw new BadArgumentType(id);
        }
    }

    private void checkIDnull(Tooltype tooltype){
        if (!Objects.isNull(tooltype.getId())){
            throw new ObjectIDisNotNull("TOOLTYPE");
        }
    }
}
