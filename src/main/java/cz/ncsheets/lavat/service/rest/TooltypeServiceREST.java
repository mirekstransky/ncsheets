package cz.ncsheets.lavat.service.rest;

import cz.ncsheets.lavat.entity.Adapter;
import cz.ncsheets.lavat.entity.Tooltype;

import java.util.List;

public interface TooltypeServiceREST {
    Tooltype getComponent(Long id);
    Tooltype saveComponent(Tooltype tooltype);
    Tooltype updateComponent(Tooltype tooltype, Long id);
    void deleteComponent(Long id);
    List<Tooltype> getComponents();
    void deleteAll();
}
