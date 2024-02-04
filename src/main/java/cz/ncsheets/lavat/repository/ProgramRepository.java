package cz.ncsheets.lavat.repository;

import cz.ncsheets.lavat.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program,Long> {
}
