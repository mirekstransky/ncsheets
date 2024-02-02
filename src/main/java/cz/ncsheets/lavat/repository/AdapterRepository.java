package cz.ncsheets.lavat.repository;

import cz.ncsheets.lavat.entity.Adapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdapterRepository extends JpaRepository<Adapter,Long> {
    @Query("SELECT m FROM Adapter m WHERE m.name = :name AND m.diameter = :diameter AND m.length = :length")
    Optional<Adapter> findDuplicate(@Param("name") String name, @Param("diameter") double diameter, @Param("length") double length);
}
