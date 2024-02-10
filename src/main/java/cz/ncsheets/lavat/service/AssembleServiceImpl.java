package cz.ncsheets.lavat.service;

import cz.ncsheets.lavat.entity.*;
import cz.ncsheets.lavat.exception.BadArgumentType;
import cz.ncsheets.lavat.exception.NotFoundException;
import cz.ncsheets.lavat.exception.ObjectIDisNotNull;
import cz.ncsheets.lavat.repository.AssembleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AssembleServiceImpl implements AssembleService {


    AssembleRepository assembleRepository;
    AdapterService adapterService;
    HolderService holderService;
    ToolService toolService;
    ProgramService programService;


    @Override
    public List<Assemble> getComponents(){
        return (List<Assemble>)assembleRepository.findAll();}

    @Override
    public Page<Assemble> findComponentsWithAdapter(Long id, Pageable pageable) {
        return assembleRepository.findComponentsWithAdapter(id,pageable);
    }

    @Override
    public Assemble getComponent(Long id) {
        Optional<Assemble> assembleOptional = assembleRepository.findById(id);
        return unwrapAssamble(assembleOptional,id);
    }
    @Override
    public Assemble saveComponent(Assemble assemble) {

        checkIDnull(assemble);
        Optional<Assemble> newAssemble = assembleRepository.findComponentByName(assemble.getName());

        Adapter adapter = adapterService.saveComponent(assemble.getAdapter());
        Holder holder = holderService.saveComponent(assemble.getHolder());
        Tool tool = toolService.saveComponent(assemble.getTool());
        Program program = programService.saveComponent(assemble.getProgram());

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
        Adapter adapter = adapterService.updateComponent(
                assemble.getAdapter(),
                assemble.getAdapter().
                        getId());
        Holder holder = holderService.updateComponent(
                assemble.getHolder(),
                assemble.getHolder().
                        getId());
        Tool tool = toolService.updateComponent(
                assemble.getTool(),
                assemble.getTool().
                        getId());
        Program program = programService.updateComponent(
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
