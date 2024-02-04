package cz.ncsheets.lavat.service.rest;

import cz.ncsheets.lavat.entity.Adapter;
import cz.ncsheets.lavat.entity.Assemble;

import java.util.List;

public interface AssembleServiceREST {
    Assemble getComponent(Long id);
    Assemble saveComponent(Assemble assemble);
    Assemble updateComponent(Assemble assemble, Long id);
    void deleteComponent(Long id);
    List<Assemble> getComponents();
    void deleteAll();

}
