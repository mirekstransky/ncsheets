package cz.ncsheets.lavat.service.rest;

import cz.ncsheets.lavat.entity.*;
import cz.ncsheets.lavat.exception.BadArgumentType;
import cz.ncsheets.lavat.exception.NotFoundException;
import cz.ncsheets.lavat.exception.ObjectIDisNotNull;
import cz.ncsheets.lavat.repository.ToolRepository;
import cz.ncsheets.lavat.repository.TooltypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ToolServiceRESTImpl implements ToolServiceREST {

    ToolRepository toolRepository;
    TooltypeRepository tooltypeRepository;
    TooltypeServiceREST tooltypeServiceREST;

    @Override
    public List<Tool> getComponents(){
        return (List<Tool>)toolRepository.findAll();
    }
    @Override
    public Tool getComponent(Long id) {
        Optional<Tool> toolOptional = toolRepository.findById(id);
        return unwrapComponent(toolOptional,id);
    }
    @Override
    public Tool saveComponent(Tool tool) {
        validateErrors(tool);
        Tooltype tooltype = saveTooltype(tool);
        tool.getTooltype().setId(tooltype.getId());
        return toolRepository.save(tool);
    }
    @Override
    public Tool updateComponent(Tool tool , Long id) {
        validateErrors(tool);
        Tool tool_copy = unwrapComponent(toolRepository.findById(id),id);
        tool.setId(id);
        Tooltype tooltype = saveTooltype(tool);
        tool.getTooltype().setId(tooltype.getId());
        return toolRepository.save(tool);
    }
    @Override
    public void deleteComponent(Long id) {
      Optional<Tool> tool = toolRepository.findById(id);
      Tool tool_copy = unwrapComponent(tool,id);
        toolRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        toolRepository.deleteAll();}
    //#############################################################################################
    private Tool unwrapComponent(Optional<Tool> entity, Long id) {
        if (entity.isPresent()){
            return entity.get();
        }
        if (id > 0){
            throw new NotFoundException("Tool", id);
        }else {
            throw new BadArgumentType(id);
        }
    }
    private boolean unwrapDuplicate(Holder holder){
        Optional<Tool> toolOptional = toolRepository.findComponentByName(holder.getName());
        if (toolOptional.isPresent()){
            return true;
        }else{
            return false;
        }
    }
    private void validateErrors(Tool tool){
        if (!Objects.isNull(tool.getId())) {
            throw new ObjectIDisNotNull("TOOL");
        }
    }
    private Tooltype saveTooltype(Tool tool){

        if (!Objects.isNull(tool.getTooltype().getId())) {
            throw new ObjectIDisNotNull("TOOLTYPE");
        }
        Optional<Tooltype> tooltype = tooltypeRepository.
                findComponentByName(tool.getTooltype().getName());
        if (!tooltype.isPresent()){
            Tooltype tooltype_new = new Tooltype();
            tooltype_new.setName(tool.getTooltype().getName());
            tooltypeServiceREST.saveComponent(tooltype_new);
            return tooltype_new;
        }else{
            return tooltype.get();
        }
    }
}
