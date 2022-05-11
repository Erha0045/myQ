package Services;

import Entities.Parameter;
import Repositories.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParameterService {

    //Field Injection
    @Autowired
    ParameterRepository parameterRepository;

    public List<Parameter> listAll(){
        return parameterRepository.findAll();
    }

}
