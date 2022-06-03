package com.hovedopgave.myq.Services;

import com.hovedopgave.myq.Entities.QueTask;
import com.hovedopgave.myq.Repositories.ParameterRepository;
import com.hovedopgave.myq.Repositories.QueRepository;
import com.hovedopgave.myq.enums.Status;
import com.hovedopgave.myq.enums.ValueType;
import com.hovedopgave.myq.model.QueTaskRequest;
import com.hovedopgave.myq.util.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class QueService {
    @Autowired
    private QueRepository queRepository;
    @Autowired
    private ParameterRepository parameterRepository;
    @Autowired
    private RequestService requestService;

    public List<QueTask> listAll() {
        return queRepository.showOnlyStatusWaiting();
    }

    public List<QueTask> saveQueTask(QueTaskRequest request, HttpServletRequest httpServletRequest) {
        List<QueTask> queTaskList = new ArrayList<>();
        if (!ValueType.isPolygon(request.getValueType().intValue())) {
            if (request.getValueType() == ValueType.BASIS.getId()) {
                QueTask queTask = getQueTask(request, null, ValueType.BASIS.getId(), httpServletRequest);
                QueTask save = queRepository.save(queTask);
                queTaskList.add(save);
            } else if (request.getValueType() == ValueType.DERIVED.getId()) {
                QueTask queTask = getQueTask(request, null, ValueType.BASIS.getId(), httpServletRequest);
                QueTask savedBasisQueTask = queRepository.save(queTask);
                queTaskList.add(savedBasisQueTask);
                queTask = getQueTask(request, savedBasisQueTask.getId(), ValueType.DERIVED.getId(), httpServletRequest);
                QueTask savedDerivedQueTask = queRepository.save(queTask);
                queTaskList.add(savedDerivedQueTask);
            } else if (request.getValueType() == ValueType.GRID.getId()) {
                QueTask queTask = getQueTask(request, null, ValueType.BASIS.getId(), httpServletRequest);
                QueTask savedBasisQueTask = queRepository.save(queTask);
                queTaskList.add(savedBasisQueTask);
                queTask = getQueTask(request, savedBasisQueTask.getId(), ValueType.DERIVED.getId(), httpServletRequest);
                QueTask savedDerivedQueTask = queRepository.save(queTask);
                queTaskList.add(savedDerivedQueTask);
                queTask = getQueTask(request, savedDerivedQueTask.getId(), ValueType.GRID.getId(), httpServletRequest);
                QueTask savedGridQueTask = queRepository.save(queTask);
                queTaskList.add(savedGridQueTask);
            }
            return queTaskList;
        } else {
            QueTask queTask = getQueTask(request, null, ValueType.BASIS.getId(), httpServletRequest);
            QueTask savedBasisQueTask = queRepository.save(queTask);
            queTaskList.add(savedBasisQueTask);
            queTask = getQueTask(request, savedBasisQueTask.getId(), ValueType.DERIVED.getId(), httpServletRequest);
            QueTask savedDerivedQueTask = queRepository.save(queTask);
            queTaskList.add(savedDerivedQueTask);
            queTask = getQueTask(request, savedDerivedQueTask.getId(), ValueType.GRID.getId(), httpServletRequest);
            QueTask savedGridQueTask = queRepository.save(queTask);
            queTaskList.add(savedGridQueTask);
            for (int i = 0; i <= 4; i++) {
                QueTask temp = new QueTask();
                temp.setFromDate(toZonedDateTime(request.getFromDate()));
                temp.setToDate(toZonedDateTime(request.getToDate()));
                temp.setParameter(parameterRepository.getById(request.getParameterId()));
                temp.setValueType(3 + i);
                temp.setUsername("MCS-GRP");
                temp.setUserLocation(requestService.getClientIp(httpServletRequest));
                if (i == 0) {
                    temp.setDependsOn(savedGridQueTask.getId());
                } else {
                    temp.setDependsOn(queTaskList.get(queTaskList.size() - 1).getId());
                }
                queRepository.save(temp);
                queTaskList.add(temp);
            }
            return queTaskList;
        }
    }

    private QueTask getQueTask(QueTaskRequest request, Long dependsOn, int valueType, HttpServletRequest httpServletRequest) {
        QueTask queTask = new QueTask();
        queTask.setFromDate(toZonedDateTime(request.getFromDate()));
        queTask.setToDate(toZonedDateTime(request.getToDate()));
        queTask.setParameter(parameterRepository.getById(request.getParameterId()));
        queTask.setValueType(valueType);
        queTask.setUsername("MCS-GRP");
        queTask.setUserLocation(requestService.getClientIp(httpServletRequest));
        queTask.setDependsOn(dependsOn);
        return queTask;
    }

    private ZonedDateTime toZonedDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime localDate = LocalDateTime.parse(date, formatter);
        return localDate.atZone(ZoneId.systemDefault());
    }

    public void deleteQueTask(long id) {
        QueTask queTask = queRepository.getById(id);
        if (queTask != null){
            queTask.setStatus(2);
            queRepository.save(queTask);
        }
        QueTask byId = queRepository.findByDependsOn(queTask.getId());
        if (byId != null) {
            deleteQueTask(byId.getId());
        }
    }

    public void retryQueTask(long id) {
        QueTask queTask = queRepository.getById(id);
        if (queTask != null) {
            queTask.setStatus(0);
            queTask.setNumTries(queTask.getNumTries() + 1);
            queRepository.save(queTask);
        }
        QueTask byId = queRepository.findByDependsOnAndStatus(queTask.getId(), Status.FAILED.getId());
        if (byId != null) {
            retryQueTask(byId.getId());
        }
    }
}
