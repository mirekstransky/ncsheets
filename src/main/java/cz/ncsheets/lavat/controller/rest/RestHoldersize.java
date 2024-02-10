package cz.ncsheets.lavat.controller.rest;

import cz.ncsheets.lavat.entity.Holdersize;
import cz.ncsheets.lavat.service.HoldersizeService;
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

    HoldersizeService holdersizeService;

    @GetMapping("")
    public ResponseEntity<List<Holdersize>> getComponents() {
        List<Holdersize> holdersizeList = holdersizeService.getComponents();
        return new ResponseEntity<>(holdersizeList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Holdersize> getComponent(@PathVariable Long id) {
        return new ResponseEntity<>(holdersizeService.getComponent(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Holdersize> saveComponent(@Valid @RequestBody Holdersize holdersize) {
        return new ResponseEntity<>(holdersizeService.saveComponent(holdersize), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Holdersize> editComponent(@PathVariable Long id, @Valid @RequestBody Holdersize holdersize) {
        return new ResponseEntity<>(holdersizeService.updateComponent(holdersize,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteComponent(@PathVariable Long id) {
        holdersizeService.deleteComponent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllComponent() {
        holdersizeService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
