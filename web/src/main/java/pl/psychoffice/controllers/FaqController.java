package pl.psychoffice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mario on 16/08/15.
 */
@Controller
public class FaqController {

    @RequestMapping("/faq")
    String blog(){
        return "faq";
    }
}
