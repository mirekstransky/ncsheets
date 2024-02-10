package cz.ncsheets.lavat.controller.rest;


import cz.ncsheets.lavat.entity.Adapter;
import cz.ncsheets.lavat.service.AdapterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ncsheets/api/adapter")
@AllArgsConstructor
public class RestAdapter {

    AdapterService adapterService;

    @GetMapping("")
    public ResponseEntity<List<Adapter>> getComponents() {
        List<Adapter> adapterList = adapterService.getComponents();
        return new ResponseEntity<>(adapterList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Adapter> getComponent(@PathVariable Long id) {
        return new ResponseEntity<>(adapterService.getComponent(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Adapter> saveComponent(@Valid @RequestBody Adapter adapter) {
        return new ResponseEntity<>(adapterService.saveComponent(adapter), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Adapter> editComponent(@PathVariable Long id, @Valid @RequestBody Adapter adapter) {
        return new ResponseEntity<>(adapterService.updateComponent(adapter,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteComponent(@PathVariable Long id) {
        adapterService.deleteComponent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllComponent() {
        adapterService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
