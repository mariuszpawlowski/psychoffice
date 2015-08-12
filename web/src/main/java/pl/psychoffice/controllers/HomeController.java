package pl.psychoffice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mariusz.Pawlowski on 2015-08-11.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    String index() {
        return "single_full";
    }
}