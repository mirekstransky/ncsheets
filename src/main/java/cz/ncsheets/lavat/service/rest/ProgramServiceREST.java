package cz.ncsheets.lavat.service.rest;

import cz.ncsheets.lavat.entity.Adapter;
import cz.ncsheets.lavat.entity.Program;

import java.util.List;

public interface ProgramServiceREST {
    Program getComponent(Long id);
    Program saveComponent(Program program);
    Program updateComponent(Program program, Long id);
    void deleteComponent(Long id);
    List<Program> getComponents();
    void deleteAll();

}
