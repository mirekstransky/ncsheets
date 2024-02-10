package cz.ncsheets.lavat.controller.rest;


import cz.ncsheets.lavat.entity.Holder;
import cz.ncsheets.lavat.service.HolderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ncsheets/api/holder")
@AllArgsConstructor
public class RestHolder {

    HolderService holderService;

    @GetMapping("")
    public ResponseEntity<List<Holder>> getComponents() {
        List<Holder> holderList = holderService.getComponents();
        return new ResponseEntity<>(holderList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Holder> getComponent(@PathVariable Long id) {
        return new ResponseEntity<>(holderService.getComponent(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Holder> saveComponent(@Valid @RequestBody Holder holder) {
        return new ResponseEntity<>(holderService.saveComponent(holder), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Holder> editComponent(@PathVariable Long id, @Valid @RequestBody Holder holder) {
        return new ResponseEntity<>(holderService.updateComponent(holder,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteComponent(@PathVariable Long id) {
        holderService.deleteComponent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllComponents() {
        holderService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
