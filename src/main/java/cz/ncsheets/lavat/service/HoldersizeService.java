package cz.ncsheets.lavat.service;

import cz.ncsheets.lavat.entity.Holdersize;

import java.util.List;
import java.util.Optional;

public interface HoldersizeService {
    Holdersize getComponent(Long id);
    Holdersize saveComponent(Holdersize holdersize);
    Holdersize updateComponent(Holdersize holdersize, Long id);
    void deleteComponent(Long id);
    List<Holdersize> getComponents();
    List<Holdersize> saveAllComponents(List<Holdersize> holdersize);
    void deleteAll();
    Optional<Holdersize> findByName(String name);

}
