package cz.ncsheets.lavat.repository;

import cz.ncsheets.lavat.entity.Holdersize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HoldersizeRepository extends JpaRepository<Holdersize,Long> {
    @Query("SELECT m FROM Holdersize m WHERE m.name = :name")
    Optional<Holdersize> findComponentByName(@Param("name") String name);
}
