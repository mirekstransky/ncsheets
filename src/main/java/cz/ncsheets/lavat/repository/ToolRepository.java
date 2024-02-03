package cz.ncsheets.lavat.repository;

import cz.ncsheets.lavat.entity.Tool;
import cz.ncsheets.lavat.entity.Tooltype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToolRepository extends JpaRepository<Tool,Long> {
    @Query("SELECT m FROM Tool m WHERE m.name = :name")
    Optional<Tool> findComponentByName(@Param("name") String name);
}
