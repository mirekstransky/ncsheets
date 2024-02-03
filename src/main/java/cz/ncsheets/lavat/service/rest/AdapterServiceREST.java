package cz.ncsheets.lavat.service.rest;
import java.util.List;
import java.util.Optional;

import cz.ncsheets.lavat.entity.Adapter;
import org.springframework.validation.BindingResult;

public interface AdapterServiceREST {
    Adapter getComponent(Long id);
    Adapter saveComponent(Adapter adapter);
    Adapter updateComponent(Adapter adapter, Long id);
    void deleteComponent(Long id);
    List<Adapter> getComponents();
    void deleteAll();

}
