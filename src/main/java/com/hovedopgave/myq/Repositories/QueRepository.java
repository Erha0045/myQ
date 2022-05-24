package com.hovedopgave.myq.Repositories;

import com.hovedopgave.myq.Entities.QueTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueRepository extends JpaRepository<QueTask,Long> {

    // nemmere at bruge at staus ikke er lig med 2
    // status 2 er brugt fordi at Niki har ændret alle statuser til 2 ellers får vi ingen resultater
    @Query("SELECT u FROM QueTask u WHERE u.status = 2 ")
    List<QueTask>showOnlyStatusWaiting();
}
