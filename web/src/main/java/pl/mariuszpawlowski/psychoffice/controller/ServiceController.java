package pl.mariuszpawlowski.psychoffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mario on 15/08/15.
 */
@Controller
public class ServiceController {

    @RequestMapping("/aboutTherapy")
    String aboutTherapy(){
        return "services/aboutTherapy";
    }

    @RequestMapping("/forWhom")
    String forWhom(){
        return "services/forWhom";
    }

}
