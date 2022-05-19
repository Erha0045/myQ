package com.hovedopgave.myq.Services;


import com.hovedopgave.myq.Entities.Parameter;
import com.hovedopgave.myq.Repositories.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParameterService {

    //Field Injection
    @Autowired
    ParameterRepository parameterRepository;
    public List<Parameter> listAll() {
        return parameterRepository.findAll();
    }

    public List<Parameter> findByTime(long id) {
        return parameterRepository.findByTimeResolutionId(id);
    }

}
