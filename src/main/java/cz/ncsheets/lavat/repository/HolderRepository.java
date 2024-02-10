package cz.ncsheets.lavat.repository;

import cz.ncsheets.lavat.entity.Holder;
import cz.ncsheets.lavat.entity.filter.HolderForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HolderRepository extends JpaRepository<Holder,Long> {
    @Query("SELECT m FROM Holder m WHERE m.name = :name")
    Optional<Holder> findComponentByName(@Param("name") String name);

    @Query("SELECT m FROM Holder m WHERE m.holderSize = :size")
    Optional<Holder> findComponentBySize(@Param("size") Long size);

//    @Query("SELECT e FROM Holder e WHERE " +
//            "(:name IS NULL OR e.name LIKE %:name%) AND " +
//            "(:diameter IS NULL OR e.diameter = :diameter) AND " +
//            "(:length IS NULL OR e.length = :length) AND " +
//            "(:size IS NULL OR e.holderSize.name LIKE %:size%)")
//    Page<Holder> findPageByName(@Param("name") String name,
//                                @Param("diameter") Double diameter,
//                                @Param("length") Double length,
//                                @Param("size") String size,
//                                Pageable pageable);

    @Query("SELECT e FROM Holder e WHERE " +
            "(:#{#form.name} IS NULL OR e.name LIKE %:#{#form.name}%) AND " +
            "(:#{#form.fromDiameter} IS NULL OR e.diameter >= :#{#form.fromDiameter}) AND " +
            "(:#{#form.toDiameter} IS NULL OR e.diameter <= :#{#form.toDiameter}) AND " +
            "(:#{#form.fromLength} IS NULL OR e.length >= :#{#form.fromLength}) AND " +
            "(:#{#form.toLength} IS NULL OR e.length <= :#{#form.toLength}) AND " +
            "(:#{#form.size} IS NULL OR e.holderSize.name LIKE %:#{#form.size}%)")
    Page<Holder> findPageByHolderForm(@Param("form") HolderForm form, Pageable pageable);
}


