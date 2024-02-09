package cz.ncsheets.lavat.service.rest;

import cz.ncsheets.lavat.entity.Holder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HolderServiceREST {
    Holder getComponent(Long id);
    Holder saveComponent(Holder holder);
    Holder updateComponent(Holder holder, Long id);
    void deleteComponent(Long id);
    List<Holder> getComponents();
    Page<Holder> getPageAll(Pageable pageable);
    void deleteAll();

}
