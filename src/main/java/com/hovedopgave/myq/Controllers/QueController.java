package com.hovedopgave.myq.Controllers;

import com.hovedopgave.myq.Entities.QueTask;
import com.hovedopgave.myq.Services.QueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class QueController {

    @Autowired
    QueService queService;

    //    @GetMapping("/que")
//    public List<QueTask> getAll(){
//        return queService.queTaskList();
//    }
    @GetMapping("/que")
    public String queList(Model model){
        List<QueTask> queTaskList = queService.listAll();
        model.addAttribute("qList", queTaskList);
        return "que";
    }
}
