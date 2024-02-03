package cz.ncsheets.lavat.service.rest;

import cz.ncsheets.lavat.entity.Adapter;
import cz.ncsheets.lavat.entity.Holder;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface HolderServiceREST {
    Holder getComponent(Long id);
    Holder saveComponent(Holder holder);
    Holder updateComponent(Holder holder, Long id);
    void deleteComponent(Long id);
    List<Holder> getComponents();
    void deleteAll();

}
