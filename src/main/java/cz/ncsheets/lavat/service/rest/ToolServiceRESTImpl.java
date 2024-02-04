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
        checkIDnull(tool);
        Optional<Tool> newTool = toolRepository.findComponentByName(tool.getName());
        Tooltype tooltype = tooltypeServiceREST.saveComponent(tool.getTooltype());

        if (newTool.isPresent()){
            tool.setId(newTool.get().getId());
            tool.setTooltype(tooltype);
            return toolRepository.save(tool);

        }else{
            tool.setTooltype(tooltype);
            return toolRepository.save(tool);
        }
    }
    @Override
    public Tool updateComponent(Tool tool , Long id) {

        Tool tool_copy = unwrapComponent(toolRepository.findById(id),id);

        Tooltype tooltype = tooltypeServiceREST.updateComponent(tool.getTooltype(),tool.getTooltype().getId());
        tool.setTooltype(tooltype);
        tool.setId(id);

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
    private void checkIDnull(Tool tool){
        if (!Objects.isNull(tool.getId())){
            throw new ObjectIDisNotNull("TOOL");
        }
    }

}
