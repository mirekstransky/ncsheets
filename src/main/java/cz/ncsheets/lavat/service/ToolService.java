package cz.ncsheets.lavat.service;

import cz.ncsheets.lavat.entity.Tool;

import java.util.List;

public interface ToolService {
    Tool getComponent(Long id);
    Tool saveComponent(Tool tool);
    Tool updateComponent(Tool tool, Long id);
    void deleteComponent(Long id);
    List<Tool> getComponents();
    void deleteAll();

}
