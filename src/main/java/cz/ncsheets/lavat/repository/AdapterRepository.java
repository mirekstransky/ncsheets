package cz.ncsheets.lavat.repository;

import cz.ncsheets.lavat.entity.Adapter;
import cz.ncsheets.lavat.entity.Holder;
import cz.ncsheets.lavat.entity.filter.AdapterForm;
import cz.ncsheets.lavat.entity.filter.HolderForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdapterRepository extends JpaRepository<Adapter,Long> {
    @Query("SELECT m FROM Adapter m WHERE m.name = :name")
    Optional<Adapter> findComponentByName(@Param("name") String name);

    @Query("SELECT e FROM Adapter e WHERE " +
            "(:#{#form.name} IS NULL OR e.name LIKE %:#{#form.name}%) AND " +
            "(:#{#form.fromDiameter} IS NULL OR e.diameter >= :#{#form.fromDiameter}) AND " +
            "(:#{#form.toDiameter} IS NULL OR e.diameter <= :#{#form.toDiameter}) AND " +
            "(:#{#form.fromLength} IS NULL OR e.length >= :#{#form.fromLength}) AND " +
            "(:#{#form.toLength} IS NULL OR e.length <= :#{#form.toLength})")
    Page<Adapter> findPageByAdapterForm(@Param("form") AdapterForm form, Pageable pageable);

}
