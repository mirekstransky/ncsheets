package cz.ncsheets.lavat.controller.rest;

import cz.ncsheets.lavat.entity.Tool;
import cz.ncsheets.lavat.service.ToolService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ncsheets/api/tool")
@AllArgsConstructor
public class RestTool {

    ToolService toolService;

    @GetMapping("")
    public ResponseEntity<List<Tool>> getComponents() {
        List<Tool> toolList = toolService.getComponents();
        return new ResponseEntity<>(toolList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tool> getComponent(@PathVariable Long id) {
        return new ResponseEntity<>(toolService.getComponent(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Tool> saveComponent(@Valid @RequestBody Tool tool) {
        return new ResponseEntity<>(toolService.saveComponent(tool), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Tool> editComponent(@PathVariable Long id, @Valid @RequestBody Tool tool) {
        return new ResponseEntity<>(toolService.updateComponent(tool,id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteComponent(@PathVariable Long id) {
        toolService.deleteComponent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllComponents() {
        toolService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
