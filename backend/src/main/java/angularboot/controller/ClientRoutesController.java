package angularboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientRoutesController {

    @RequestMapping({
        "/dashboard",
        "/heroes",
        "/detail/*"
    })
    public String forwardToClientApp(){
        return "forward:/index.html";
    }
}
