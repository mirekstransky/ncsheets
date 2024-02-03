package cz.ncsheets.lavat.repository;

import cz.ncsheets.lavat.entity.Adapter;
import cz.ncsheets.lavat.entity.Holder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HolderRepository extends JpaRepository<Holder,Long> {
    @Query("SELECT m FROM Holder m WHERE m.name = :name")
    Optional<Adapter> findComponentByName(@Param("name") String name);
}
