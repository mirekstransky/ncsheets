package cz.ncsheets.lavat.repository;

import cz.ncsheets.lavat.entity.Holder;
import cz.ncsheets.lavat.entity.Tool;
import cz.ncsheets.lavat.entity.Tooltype;
import cz.ncsheets.lavat.entity.filter.HolderForm;
import cz.ncsheets.lavat.entity.filter.ToolForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToolRepository extends JpaRepository<Tool,Long> {
    @Query("SELECT m FROM Tool m WHERE m.name = :name")
    Optional<Tool> findComponentByName(@Param("name") String name);

    @Query("SELECT e FROM Tool e WHERE " +
            "(:#{#form.name} IS NULL OR e.name LIKE %:#{#form.name}%) AND " +
            "(:#{#form.fromDiameter} IS NULL OR e.diameter >= :#{#form.fromDiameter}) AND " +
            "(:#{#form.toDiameter} IS NULL OR e.diameter <= :#{#form.toDiameter}) AND " +
            "(:#{#form.fromLength} IS NULL OR e.length >= :#{#form.fromLength}) AND " +
            "(:#{#form.toLength} IS NULL OR e.length <= :#{#form.toLength}) AND " +
            "(:#{#form.tooltype} IS NULL OR e.tooltype.name LIKE %:#{#form.tooltype}%)")
    Page<Tool> findPageByToolForm(@Param("form") ToolForm form, Pageable pageable);

}
