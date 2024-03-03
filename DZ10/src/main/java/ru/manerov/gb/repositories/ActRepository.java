package ru.manerov.gb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.manerov.gb.model.Act;

import java.util.List;

@Repository
public interface ActRepository extends JpaRepository<Act, Long> {

    @Query("SELECT e FROM Act e WHERE e.reportingPeriod= :reportingPeriod")
    List<Act> findActByReportingPeriod(String reportingPeriod);

}
