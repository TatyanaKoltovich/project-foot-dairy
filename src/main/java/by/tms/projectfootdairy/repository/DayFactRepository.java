package by.tms.projectfootdairy.repository;

import by.tms.projectfootdairy.entity.DayFact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayFactRepository extends JpaRepository<DayFact, Long> {
}
