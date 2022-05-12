package com.hovedopgave.myq.Services;

import com.hovedopgave.myq.Entities.TimeResolution;
import com.hovedopgave.myq.Repositories.TimeResolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TimeResolutionService {
    @Autowired
    TimeResolutionRepository timeResolutionRepository;

    public List<TimeResolution> findAll(){
        return timeResolutionRepository.findAll();
    }
}
