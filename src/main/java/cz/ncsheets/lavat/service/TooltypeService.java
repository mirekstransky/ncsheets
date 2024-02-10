package cz.ncsheets.lavat.service;

import cz.ncsheets.lavat.entity.Tooltype;

import java.util.List;

public interface TooltypeService {
    Tooltype getComponent(Long id);
    Tooltype saveComponent(Tooltype tooltype);
    Tooltype updateComponent(Tooltype tooltype, Long id);
    void deleteComponent(Long id);
    List<Tooltype> getComponents();
    void deleteAll();
}
