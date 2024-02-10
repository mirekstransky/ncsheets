package cz.ncsheets.lavat.service;

import cz.ncsheets.lavat.entity.Holder;
import cz.ncsheets.lavat.entity.filter.HolderForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HolderService {
    Holder getComponent(Long id);
    Holder saveComponent(Holder holder);
    Holder updateComponent(Holder holder, Long id);
    void deleteComponent(Long id);
    List<Holder> getComponents();
    Page<Holder> getPageAll(Pageable pageable);
    Page<Holder> findPageByHolderForm(HolderForm form, Pageable pageable);
    void deleteAll();

}
