package cz.ncsheets.lavat.controller.rest;

import cz.ncsheets.lavat.entity.Holdersize;
import cz.ncsheets.lavat.service.rest.HoldersizeServiceREST;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ncsheets/api/holdersize")
@AllArgsConstructor
public class RestHoldersize {

    HoldersizeServiceREST holdersizeServiceREST;

    @GetMapping("")
    public ResponseEntity<List<Holdersize>> getComponents() {
        List<Holdersize> holdersizeList = holdersizeServiceREST.getComponents();
        return new ResponseEntity<>(holdersizeList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Holdersize> getComponent(@PathVariable Long id) {
        return new ResponseEntity<>(holdersizeServiceREST.getComponent(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Holdersize> saveComponent(@Valid @RequestBody Holdersize holdersize) {
        return new ResponseEntity<>(holdersizeServiceREST.saveComponent(holdersize), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Holdersize> editComponent(@PathVariable Long id, @Valid @RequestBody Holdersize holdersize) {
        return new ResponseEntity<>(holdersizeServiceREST.updateComponent(holdersize,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteComponent(@PathVariable Long id) {
        holdersizeServiceREST.deleteComponent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllComponent() {
        holdersizeServiceREST.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
