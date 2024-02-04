package cz.ncsheets.lavat.repository;

import cz.ncsheets.lavat.entity.Holdersize;
import cz.ncsheets.lavat.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProgramRepository extends JpaRepository<Program,Long> {
    @Query("SELECT m FROM Program m WHERE m.name = :name")
    Optional<Program> findComponentByName(@Param("name") String name);
}
