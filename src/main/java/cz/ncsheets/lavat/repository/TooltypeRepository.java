package cz.ncsheets.lavat.repository;

import cz.ncsheets.lavat.entity.Holdersize;
import cz.ncsheets.lavat.entity.Tooltype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TooltypeRepository extends JpaRepository<Tooltype,Long> {
    @Query("SELECT m FROM Tooltype m WHERE m.name = :name")
    Optional<Tooltype> findComponentByName(@Param("name") String name);
}
