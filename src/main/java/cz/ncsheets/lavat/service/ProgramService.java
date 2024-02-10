package cz.ncsheets.lavat.service;

import cz.ncsheets.lavat.entity.Program;

import java.util.List;

public interface ProgramService {
    Program getComponent(Long id);
    Program saveComponent(Program program);
    Program updateComponent(Program program, Long id);
    void deleteComponent(Long id);
    List<Program> getComponents();
    void deleteAll();

}
