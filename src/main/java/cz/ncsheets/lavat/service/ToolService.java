package cz.ncsheets.lavat.service;

import cz.ncsheets.lavat.entity.Tool;
import cz.ncsheets.lavat.entity.filter.ToolForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ToolService {
    Tool getComponent(Long id);
    Tool saveComponent(Tool tool);
    Tool updateComponent(Tool tool, Long id);
    void deleteComponent(Long id);
    List<Tool> getComponents();
    Page<Tool> getPageAll(Pageable pageable);
    Page<Tool> findPageByToolForm(ToolForm form, Pageable pageable);
    void deleteAll();

}
