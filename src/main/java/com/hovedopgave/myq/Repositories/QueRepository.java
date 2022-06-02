package com.hovedopgave.myq.Repositories;

import com.hovedopgave.myq.Entities.QueTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueRepository extends JpaRepository<QueTask,Long> {

    @Query("SELECT u FROM QueTask u WHERE u.status in (0,1,3)")
    List<QueTask>showOnlyStatusWaiting();

    QueTask findByDependsOn(Long id);

    QueTask findByDependsOnAndStatus(long id, int status);
}
