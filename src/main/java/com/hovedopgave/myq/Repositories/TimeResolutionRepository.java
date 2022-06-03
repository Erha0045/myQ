package com.hovedopgave.myq.Repositories;

import com.hovedopgave.myq.Entities.TimeResolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeResolutionRepository extends JpaRepository<TimeResolution, Long> {

    @Query("SELECT u FROM TimeResolution u  ")
    List<TimeResolution> findAllTimeResolutions();
}
