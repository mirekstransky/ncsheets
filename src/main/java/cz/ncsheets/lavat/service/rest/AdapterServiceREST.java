package cz.ncsheets.lavat.service.rest;
import java.util.List;
import java.util.Optional;

import cz.ncsheets.lavat.entity.Adapter;
import org.springframework.validation.BindingResult;

public interface AdapterServiceREST {
    Adapter getAdapter(Long id);
    Adapter saveAdapter(Adapter adapter, BindingResult bindingResult);
    Adapter updateAdapter(Adapter adapter, Long id);
    void deleteAdapter(Long id);
    List<Adapter> getAdapters();
    List<Adapter> addBatch(List<Adapter> adapters, BindingResult bindingResult);
    void deleteAll();

}
