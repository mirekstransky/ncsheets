package cz.ncsheets.lavat.service.rest;

import cz.ncsheets.lavat.entity.Adapter;
import cz.ncsheets.lavat.entity.Program;
import cz.ncsheets.lavat.exception.BadArgumentType;
import cz.ncsheets.lavat.exception.NotFoundException;
import cz.ncsheets.lavat.exception.ObjectIDisNotNull;
import cz.ncsheets.lavat.repository.ProgramRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProgramServiceRESTImpl implements ProgramServiceREST {


    ProgramRepository programRepository;

    @Override
    public List<Program> getComponents(){
        return (List<Program>)programRepository.findAll();}
    @Override
    public Program getComponent(Long id) {
        Optional<Program> programOptional = programRepository.findById(id);
        return unwrapProgram(programOptional,id);
    }
    @Override
    public Program saveComponent(Program program) {
        validateErrors(program);
//        if (findComponent(adapter)) throw new DuplicateObjectException();
        return programRepository.save(program);
    }
    @Override
    public Program updateComponent(Program program, Long id) {
        validateErrors(program);
        Program program_copy = unwrapProgram(programRepository.findById(id),id);
        program.setId(id);
        return programRepository.save(program);
    }
    @Override
    public void deleteComponent(Long id) {
      Optional<Program> program = programRepository.findById(id);
        Program program_copy = unwrapProgram(program,id);
        programRepository.deleteById(id);
    }
    @Override
    public void deleteAll() {
        programRepository.deleteAll();}
    //#############################################################################################
    private Program unwrapProgram(Optional<Program> entity, Long id) {
        if (entity.isPresent()){
            return entity.get();
        }
        if (id > 0){
            throw new NotFoundException("Adapter", id);
        }else {
            throw new BadArgumentType(id);
        }
    }

    private void validateErrors(Program program){
        if (!Objects.isNull(program.getId())) {
            throw new ObjectIDisNotNull("PROGRAM");
        }
    }

}
