package cz.ncsheets.lavat.controller.rest;

import cz.ncsheets.lavat.entity.Program;
import cz.ncsheets.lavat.service.rest.ProgramServiceREST;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ncsheets/api/program")
@AllArgsConstructor
public class RestProgram {

    ProgramServiceREST programServiceREST;

    @GetMapping("")
    public ResponseEntity<List<Program>> getComponents() {
        List<Program> programList = programServiceREST.getComponents();
        return new ResponseEntity<>(programList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Program> getComponent(@PathVariable Long id) {
        return new ResponseEntity<>(programServiceREST.getComponent(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Program> saveComponent(@Valid @RequestBody Program program) {
        return new ResponseEntity<>(programServiceREST.saveComponent(program), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Program> editComponent(@PathVariable Long id, @Valid @RequestBody Program program) {
        return new ResponseEntity<>(programServiceREST.updateComponent(program,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteComponent(@PathVariable Long id) {
        programServiceREST.deleteComponent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllComponent() {
        programServiceREST.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
