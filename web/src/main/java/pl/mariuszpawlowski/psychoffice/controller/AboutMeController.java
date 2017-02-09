package pl.mariuszpawlowski.psychoffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mario on 12/08/15.
 */
@Controller
public class AboutMeController {

    @RequestMapping("/aboutBiography")
    String aboutBiography() {
        return "about/aboutBiography";
    }

}
