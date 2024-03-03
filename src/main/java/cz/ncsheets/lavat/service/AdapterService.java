package cz.ncsheets.lavat.service;
import java.util.List;

import cz.ncsheets.lavat.entity.Adapter;
import cz.ncsheets.lavat.entity.filter.AdapterForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdapterService {
    Adapter getComponent(Long id);
    Adapter saveComponent(Adapter adapter);
    Adapter updateComponent(Adapter adapter, Long id);
    void deleteComponent(Long id);
    List<Adapter> getComponents();
    Page<Adapter> getPageAll(Pageable pageable);
    Page<Adapter> findPageByAdapterForm(AdapterForm form, Pageable pageable);
    void deleteAll();

}
