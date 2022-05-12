package com.hovedopgave.myq.Controllers;

import com.hovedopgave.myq.Entities.Parameter;
import com.hovedopgave.myq.Entities.QueTask;
import com.hovedopgave.myq.Entities.TimeResolution;
import com.hovedopgave.myq.Repositories.ParameterRepository;
import com.hovedopgave.myq.Repositories.TimeResolutionRepository;
import com.hovedopgave.myq.Services.ParameterService;
import com.hovedopgave.myq.Services.QueService;
import com.hovedopgave.myq.Services.TimeResolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.List;

@Controller
public class indexController {

    @Autowired
    ParameterService parameterService;
    ParameterRepository parameterRepository;
    @Autowired
    TimeResolutionService timeResolutionService;

    @Autowired
    QueService queService;


    @GetMapping("/")
    public String showHomePage(Model model){
        List<Parameter> parameterList = parameterService.listAll();
        model.addAttribute("plist", parameterList);

            List<TimeResolution> timeList = timeResolutionService.findAll();
            model.addAttribute("showTime", timeList);

        List<QueTask> queTaskList = queService.listAll();
        model.addAttribute("qList", queTaskList);

        return "index";

    }
}
