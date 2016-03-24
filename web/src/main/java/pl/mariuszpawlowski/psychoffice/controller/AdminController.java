package pl.mariuszpawlowski.psychoffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mariusz.Pawlowski on 2015-08-11.
 */
@Controller
public class AdminController {

    @RequestMapping("/admin")
    String admin() {
        return "admin";
    }
}
