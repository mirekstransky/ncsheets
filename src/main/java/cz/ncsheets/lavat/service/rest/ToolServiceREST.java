package cz.ncsheets.lavat.service.rest;

import cz.ncsheets.lavat.entity.Holder;
import cz.ncsheets.lavat.entity.Tool;

import java.util.List;

public interface ToolServiceREST {
    Tool getComponent(Long id);
    Tool saveComponent(Tool tool);
    Tool updateComponent(Tool tool, Long id);
    void deleteComponent(Long id);
    List<Tool> getComponents();
    void deleteAll();

}
