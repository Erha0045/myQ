package com.hovedopgave.myq.Repositories;

import com.hovedopgave.myq.Entities.TimeResolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeResolutionRepository extends JpaRepository<TimeResolution, Long> {
    //    @Query("SELECT u FROM TimeResolution u WHERE u.name = 1 ")

    //    @Query("SELECT o.name FROM TimeResolution o")
//@Query("SELECT o FROM TimeResolution o")
    @Query("SELECT u FROM TimeResolution u  ")
//        @Query("select u.id, u.name from TimeResolution u")
    List<TimeResolution> findAllTimeResolutions();
}
