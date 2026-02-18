package Hospital.Management.Hospital.Management.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/public")
public class healthController {

    @GetMapping("/health")
    public String getHealth(){
        return "OK";
    }
}
