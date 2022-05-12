package com.hovedopgave.myq.Repositories;

import com.hovedopgave.myq.Entities.QueTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueRepository extends JpaRepository<QueTask,Long> {
}
