package Controllers;

import Entities.Parameter;
import Repositories.ParameterRepository;
import Services.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class indexController {

    @Autowired
    ParameterService parameterService;
    ParameterRepository parameterRepository;


    @GetMapping("/index")
    public String elementList(Model model){
        List<Parameter> parameterList = parameterService.listAll();
        model.addAttribute("plist", parameterList);

        return ("index");
    }
}
