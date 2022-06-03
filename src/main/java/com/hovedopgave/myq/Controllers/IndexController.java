package com.hovedopgave.myq.Controllers;

import com.google.gson.Gson;
import com.hovedopgave.myq.Entities.Parameter;
import com.hovedopgave.myq.Entities.QueTask;
import com.hovedopgave.myq.Entities.TimeResolution;
import com.hovedopgave.myq.Services.ParameterService;
import com.hovedopgave.myq.Services.QueService;
import com.hovedopgave.myq.Services.TimeResolutionService;
import com.hovedopgave.myq.model.QueTaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = {"", "demo"})
public class IndexController {

    @Autowired
    ParameterService parameterService;
    @Autowired
    TimeResolutionService timeResolutionService;
    @Autowired
    QueService queService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        List<Parameter> parameterList = parameterService.listAll();
        model.addAttribute("plist", parameterList);
        List<QueTask> queTaskList = queService.listAll();
        model.addAttribute("qList", queTaskList);
        List<TimeResolution> timeResolutionList = timeResolutionService.showAllTimes();
        model.addAttribute("dropDownElements", timeResolutionList);
        model.addAttribute("queTaskRequest", new QueTaskRequest());
        return "index";
    }

//    @ResponseBody
//    @GetMapping("/parameterbyid/{id}")
//    public String loadParameterByTimeId(@PathVariable("id") long id) {
//        Gson gson = new Gson();
//        return gson.toJson(parameterService.findByTime(id));
//    }

    @PostMapping("/saveQueTask")
    public String saveQueTask(@ModelAttribute("queTaskRequest") QueTaskRequest queTaskRequest, Model model, HttpServletRequest httpServletRequest, RedirectAttributes redirAttrs) {
        if (!StringUtils.hasLength(queTaskRequest.getFromDate())
                && !StringUtils.hasLength(queTaskRequest.getToDate())
                && StringUtils.hasLength(queTaskRequest.getFullDate())) {
            String[] split = queTaskRequest.getFullDate().split("-");
            queTaskRequest.setFromDate(split[0].substring(0, split[0].length() - 1));
            queTaskRequest.setToDate(split[1].substring(1));
        }
        List<QueTask> queTaskList = queService.saveQueTask(queTaskRequest, httpServletRequest);
        model.addAttribute("qList", queTaskList);
        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        queService.deleteQueTask(id);
        return "redirect:/";
    }
    @GetMapping("/retry/{id}")
    public String retry(@PathVariable("id")long id){
        queService.retryQueTask(id);
        return "redirect:/";
    }





}