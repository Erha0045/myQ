package com.hovedopgave.myq.Services;

import com.hovedopgave.myq.Entities.QueTask;
import com.hovedopgave.myq.Repositories.QueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueService {
    @Autowired
    QueRepository queRepository;

    public List<QueTask> listAll(){
        return queRepository.findAll();
    }

}
