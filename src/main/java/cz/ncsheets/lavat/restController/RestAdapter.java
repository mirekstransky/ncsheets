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
    public ResponseEntity<List<Adapter>> getComponents() {
        List<Adapter> adapterList = adapterServiceREST.getComponents();
        return new ResponseEntity<>(adapterList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Adapter> getComponent(@PathVariable Long id) {
        return new ResponseEntity<>(adapterServiceREST.getComponent(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Adapter> saveComponent(@Valid @RequestBody Adapter adapter) {
        return new ResponseEntity<>(adapterServiceREST.saveComponent(adapter), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Adapter> editComponent(@PathVariable Long id, @Valid @RequestBody Adapter adapter) {
        return new ResponseEntity<>(adapterServiceREST.updateComponent(adapter,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteComponent(@PathVariable Long id) {
        adapterServiceREST.deleteComponent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllComponent() {
        adapterServiceREST.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
