package cz.ncsheets.lavat.service.rest;

import cz.ncsheets.lavat.entity.Holdersize;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface HoldersizeServiceREST {
    Holdersize getComponent(Long id);
    Holdersize saveComponent(Holdersize holdersize);
    Holdersize updateComponent(Holdersize holdersize, Long id);
    void deleteComponent(Long id);
    List<Holdersize> getComponents();
    List<Holdersize> saveAllComponents(List<Holdersize> holdersize);
    void deleteAll();

}
