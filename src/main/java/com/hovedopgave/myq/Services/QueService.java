package com.hovedopgave.myq.Services;

import com.hovedopgave.myq.Entities.QueTask;
import com.hovedopgave.myq.Repositories.QueRepository;
import com.hovedopgave.myq.model.QueTaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class QueService {
    @Autowired
    QueRepository queRepository;

    //    public List<QueTask> listAll(){
//        return queRepository.findAll();
//    }
    public List<QueTask> listAll() {
        return queRepository.showOnlyStatusWaiting();
    }

    public List<QueTask> saveQueTask(QueTaskRequest request) {
        List<QueTask> queTaskList = new ArrayList<>();
        if (request.getValueType() != 3) {
            QueTask queTask = new QueTask();
            queTask.setFrom_date(toZonedDateTime(request.getFromDate()));
            queTask.setTo_date(toZonedDateTime(request.getToDate()));
            queTask.setParameter_id(request.getParameterId());
            queTask.setValuetype(request.getValueType().intValue());
            QueTask save = queRepository.save(queTask);
            queTaskList.add(save);
            return queTaskList;
        } else {
            for (int i = 0; i <= 4; i++) {
                QueTask queTask = new QueTask();
                queTask.setFrom_date(toZonedDateTime(request.getFromDate()));
                queTask.setTo_date(toZonedDateTime(request.getToDate()));
                queTask.setParameter_id(request.getParameterId());
                queTask.setValuetype(3 + i);
                queTaskList.add(queTask);
            }
            return queRepository.saveAll(queTaskList);
        }
    }

    private ZonedDateTime toZonedDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate.atStartOfDay(ZoneId.systemDefault());
    }

    public void deleteQueTask(long id) {
        QueTask queTask = queRepository.getById(id);
        if (queTask != null){
            queTask.setStatus(2);
            queRepository.save(queTask);
        }
    }
}
