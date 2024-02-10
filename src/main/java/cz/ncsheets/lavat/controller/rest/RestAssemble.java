package cz.ncsheets.lavat.controller.rest;

import cz.ncsheets.lavat.entity.Assemble;
import cz.ncsheets.lavat.service.AssembleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ncsheets/api/assemble")
@AllArgsConstructor
public class RestAssemble{


    AssembleService assembleService;

    @GetMapping("")
    public ResponseEntity<List<Assemble>> getComponents() {
        List<Assemble> assembleList = assembleService.getComponents();
        return new ResponseEntity<>(assembleList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Assemble> getComponent(@PathVariable Long id) {
        return new ResponseEntity<>(assembleService.getComponent(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Assemble> saveComponent(@Valid @RequestBody Assemble assemble) {
        return new ResponseEntity<>(assembleService.saveComponent(assemble), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Assemble> editComponent(@PathVariable Long id, @Valid @RequestBody Assemble assemble) {
        return new ResponseEntity<>(assembleService.updateComponent(assemble,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteComponent(@PathVariable Long id) {
        assembleService.deleteComponent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllComponent() {
        assembleService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
