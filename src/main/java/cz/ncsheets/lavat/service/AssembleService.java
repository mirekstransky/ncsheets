package cz.ncsheets.lavat.service;

import cz.ncsheets.lavat.entity.Assemble;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AssembleService {
    Assemble getComponent(Long id);
    Assemble saveComponent(Assemble assemble);
    Assemble updateComponent(Assemble assemble, Long id);
    void deleteComponent(Long id);
    List<Assemble> getComponents();
    Page<Assemble> findComponentsWithAdapter(Long id, Pageable pageable);

    void deleteAll();

}
