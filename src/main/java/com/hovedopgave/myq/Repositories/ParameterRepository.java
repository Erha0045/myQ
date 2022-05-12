package com.hovedopgave.myq.Repositories;

import com.hovedopgave.myq.Entities.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {
//    List<Parameter> paramlist();
}
