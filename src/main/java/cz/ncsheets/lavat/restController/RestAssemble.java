package cz.ncsheets.lavat.restController;

import cz.ncsheets.lavat.entity.Adapter;
import cz.ncsheets.lavat.entity.Assemble;
import cz.ncsheets.lavat.service.rest.AdapterServiceREST;
import cz.ncsheets.lavat.service.rest.AssembleServiceREST;
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


    AssembleServiceREST assembleServiceREST;

    @GetMapping("")
    public ResponseEntity<List<Assemble>> getComponents() {
        List<Assemble> assembleList = assembleServiceREST.getComponents();
        return new ResponseEntity<>(assembleList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Assemble> getComponent(@PathVariable Long id) {
        return new ResponseEntity<>(assembleServiceREST.getComponent(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Assemble> saveComponent(@Valid @RequestBody Assemble assemble) {
        return new ResponseEntity<>(assembleServiceREST.saveComponent(assemble), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Assemble> editComponent(@PathVariable Long id, @Valid @RequestBody Assemble assemble) {
        return new ResponseEntity<>(assembleServiceREST.updateComponent(assemble,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteComponent(@PathVariable Long id) {
        assembleServiceREST.deleteComponent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllComponent() {
        assembleServiceREST.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
