package cz.ncsheets.lavat.repository;

import cz.ncsheets.lavat.entity.Holder;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolderRepository extends JpaRepository<Holder,Long> {
}
