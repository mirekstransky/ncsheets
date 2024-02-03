package cz.ncsheets.lavat.restController;


import cz.ncsheets.lavat.entity.Adapter;
import cz.ncsheets.lavat.entity.Holder;
import cz.ncsheets.lavat.service.rest.AdapterServiceREST;
import cz.ncsheets.lavat.service.rest.HolderServiceREST;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ncsheets/api/holder")
@AllArgsConstructor
public class RestHolder {

    HolderServiceREST holderServiceREST;

    @GetMapping("")
    public ResponseEntity<List<Holder>> getComponents() {
        List<Holder> holderList = holderServiceREST.getComponents();
        return new ResponseEntity<>(holderList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Holder> getComponent(@PathVariable Long id) {
        return new ResponseEntity<>(holderServiceREST.getComponent(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Holder> saveComponent(@Valid @RequestBody Holder holder) {
        return new ResponseEntity<>(holderServiceREST.saveComponent(holder), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Holder> editComponent(@PathVariable Long id, @Valid @RequestBody Holder holder) {
        return new ResponseEntity<>(holderServiceREST.updateComponent(holder,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteComponent(@PathVariable Long id) {
        holderServiceREST.deleteComponent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllComponents() {
        holderServiceREST.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
