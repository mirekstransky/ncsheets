package cz.ncsheets.lavat.controller.rest;

import cz.ncsheets.lavat.entity.Tooltype;
import cz.ncsheets.lavat.service.TooltypeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ncsheets/api/tooltype")
@AllArgsConstructor
public class RestTooltype {

    TooltypeService tooltypeService;

    @GetMapping("")
    public ResponseEntity<List<Tooltype>> getComponents() {
        List<Tooltype> tooltypeList = tooltypeService.getComponents();
        return new ResponseEntity<>(tooltypeList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tooltype> getComponent(@PathVariable Long id) {
        return new ResponseEntity<>(tooltypeService.getComponent(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Tooltype> saveComponent(@Valid @RequestBody Tooltype tooltype) {
        return new ResponseEntity<>(tooltypeService.saveComponent(tooltype), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Tooltype> editComponent(@PathVariable Long id, @Valid @RequestBody Tooltype tooltype) {
        return new ResponseEntity<>(tooltypeService.updateComponent(tooltype,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteComponent(@PathVariable Long id) {
        tooltypeService.deleteComponent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllComponent() {
        tooltypeService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
