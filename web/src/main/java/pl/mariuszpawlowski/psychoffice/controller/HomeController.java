package pl.mariuszpawlowski.psychoffice.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mariusz.Pawlowski on 2015-08-11.
 */

@Controller
public class HomeController {


    @RequestMapping("/")
    String index(Authentication authentication) {



        return "index";
        //return "home";
    }
}
