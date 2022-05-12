package com.hovedopgave.myq.Repositories;

import com.hovedopgave.myq.Entities.TimeResolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeResolutionRepository extends JpaRepository<TimeResolution, Long> {

}
