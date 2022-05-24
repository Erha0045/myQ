package com.hovedopgave.myq.Repositories;

import com.hovedopgave.myq.Entities.QueTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueRepository extends JpaRepository<QueTask,Long> {

    // nemmere at bruge at staus ikke er lig med 2
    @Query("SELECT u FROM QueTask u WHERE u.status = 0 ")
    List<QueTask>showOnlyStatusWaiting();
}
