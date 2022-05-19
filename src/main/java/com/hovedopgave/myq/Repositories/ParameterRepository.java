package com.hovedopgave.myq.Repositories;

import com.hovedopgave.myq.Entities.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {
//    @Query("SELECT u FROM Parameter u WHERE u.time_resolution_id = 1 ")
//    List<Parameter> findAllParameters();

    List<Parameter> findByTimeResolutionId(long timeResolutionId);

}
