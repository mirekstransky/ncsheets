package cz.ncsheets.lavat.service.rest;

import cz.ncsheets.lavat.entity.*;
import cz.ncsheets.lavat.exception.BadArgumentType;
import cz.ncsheets.lavat.exception.NotFoundException;
import cz.ncsheets.lavat.exception.ObjectIDisNotNull;
import cz.ncsheets.lavat.repository.AssembleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AssembleServiceRESTImpl implements AssembleServiceREST {


    AssembleRepository assembleRepository;

    AdapterServiceREST adapterServiceREST;
    HolderServiceREST holderServiceREST;
    ToolServiceREST toolServiceREST;
    ProgramServiceREST programServiceREST;


    @Override
    public List<Assemble> getComponents(){
        return (List<Assemble>)assembleRepository.findAll();}
    @Override
    public Assemble getComponent(Long id) {
        Optional<Assemble> assembleOptional = assembleRepository.findById(id);
        return unwrapAssamble(assembleOptional,id);
    }
    @Override
    public Assemble saveComponent(Assemble assemble) {

        checkIDnull(assemble);
        Optional<Assemble> newAssemble = assembleRepository.findComponentByName(assemble.getName());

        Adapter adapter = adapterServiceREST.saveComponent(assemble.getAdapter());
        Holder holder = holderServiceREST.saveComponent(assemble.getHolder());
        Tool tool = toolServiceREST.saveComponent(assemble.getTool());
        Program program = programServiceREST.saveComponent(assemble.getProgram());

        assemble.setAdapter(adapter);
        assemble.setHolder(holder);
        assemble.setTool(tool);
        assemble.setProgram(program);
        if (newAssemble.isPresent()){
            assemble.setId(newAssemble.get().getId());
        }
        return assembleRepository.save(assemble);

    }
    @Override
    public Assemble updateComponent(Assemble assemble, Long id) {
        Assemble assemble_copy = unwrapComponent(assembleRepository.findById(id),id);
        Adapter adapter = adapterServiceREST.updateComponent(
                assemble.getAdapter(),
                assemble.getAdapter().
                        getId());
        Holder holder = holderServiceREST.updateComponent(
                assemble.getHolder(),
                assemble.getHolder().
                        getId());
        Tool tool = toolServiceREST.updateComponent(
                assemble.getTool(),
                assemble.getTool().
                        getId());
        Program program = programServiceREST.updateComponent(
                assemble.getProgram(),
                assemble.getProgram().
                        getId());
        assemble.setAdapter(adapter);
        assemble.setHolder(holder);
        assemble.setTool(tool);
        assemble.setProgram(program);
        assemble.setId(id);
        return assembleRepository.save(assemble);
    }
    @Override
    public void deleteComponent(Long id) {
      Optional<Assemble> assemble = assembleRepository.findById(id);
        Assemble assemble_copy = unwrapAssamble(assemble,id);
        assembleRepository.deleteById(id);
    }
    @Override
    public void deleteAll() {
        assembleRepository.deleteAll();}
    //#############################################################################################
    private Assemble unwrapAssamble(Optional<Assemble> entity, Long id) {
        if (entity.isPresent()){
            return entity.get();
        }
        if (id > 0){
            throw new NotFoundException("Assemble", id);
        }else {
            throw new BadArgumentType(id);
        }
    }

    private void checkIDnull(Assemble assemble){
        if (!Objects.isNull(assemble.getId())) {
            throw new ObjectIDisNotNull("ASSEMBLE");
        }
    }

    private Assemble unwrapComponent(Optional<Assemble> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        if (id > 0){
            throw new NotFoundException("ASSEMBLE", id);
        }else {
            throw new BadArgumentType(id);
        }
    }
}
