package cz.ncsheets.lavat.repository;

import cz.ncsheets.lavat.entity.Adapter;
import cz.ncsheets.lavat.entity.Assemble;
import cz.ncsheets.lavat.entity.Holder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssembleRepository extends JpaRepository<Assemble,Long> {
    @Query("SELECT m FROM Assemble m WHERE m.name = :name")
    Optional<Assemble> findComponentByName(@Param("name") String id);

    @Query("SELECT m FROM Assemble m WHERE m.adapter.id = :id")
    Page<Assemble> findComponentsWithAdapter(@Param("id") Long id, Pageable pageable);

}
