package cz.ncsheets.lavat.restController;


import cz.ncsheets.lavat.entity.Adapter;
import cz.ncsheets.lavat.service.rest.AdapterServiceREST;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ncsheets/api/adapter")
@AllArgsConstructor
public class RestAdapter {

    AdapterServiceREST adapterServiceREST;

    @GetMapping("")
    public ResponseEntity<List<Adapter>> getAdapters() {
        List<Adapter> adapterList = adapterServiceREST.getAdapters();
        return new ResponseEntity<>(adapterList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Adapter> getAdapter(@PathVariable Long id) {
        return new ResponseEntity<>(adapterServiceREST.getAdapter(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Adapter> saveAdapter(@Valid @RequestBody Adapter adapter, BindingResult bindingResult) {
        return new ResponseEntity<>(adapterServiceREST.saveAdapter(adapter,bindingResult), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Adapter> editAdapter(@PathVariable Long id, @Valid @RequestBody Adapter adapter) {
        return new ResponseEntity<>(adapterServiceREST.updateAdapter(adapter,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAdapter(@PathVariable Long id) {
        adapterServiceREST.deleteAdapter(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllAdapters() {
        adapterServiceREST.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/batch")
    public ResponseEntity<List<Adapter>> addBatch(@Valid @RequestBody List<Adapter> adapters, BindingResult bindingResult) {
        return new ResponseEntity<>(adapterServiceREST.addBatch(adapters,bindingResult), HttpStatus.CREATED);
    }


}
