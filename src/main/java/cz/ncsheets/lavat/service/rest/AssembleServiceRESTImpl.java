package cz.ncsheets.lavat.service.rest;

import cz.ncsheets.lavat.entity.Assemble;
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
        validateErrors(assemble);
//        if (findComponent(adapter)) throw new DuplicateObjectException();
        return assembleRepository.save(assemble);
    }
    @Override
    public Assemble updateComponent(Assemble assemble, Long id) {
        validateErrors(assemble);
        Assemble assamble_copy = unwrapAssamble(assembleRepository.findById(id),id);
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
    private void validateErrors(Assemble assemble){
        if (!Objects.isNull(assemble.getId())) {
            throw new ObjectIDisNotNull("ASSEMBLE");
        }
    }
}
