package cz.ncsheets.lavat.service;
import java.util.List;

import cz.ncsheets.lavat.entity.Adapter;

public interface AdapterService {
    Adapter getComponent(Long id);
    Adapter saveComponent(Adapter adapter);
    Adapter updateComponent(Adapter adapter, Long id);
    void deleteComponent(Long id);
    List<Adapter> getComponents();
    void deleteAll();

}
