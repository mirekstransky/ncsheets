package cz.ncsheets.lavat.repository;

import cz.ncsheets.lavat.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolRepository extends JpaRepository<Tool,Long> {
}
