package pl.mariuszpawlowski.psychoffice.controllers;

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

    @RequestMapping("/aboutQualifications")
    String aboutQualifications() {
        return "about/aboutQualifications";
    }

    @RequestMapping("/aboutHow")
    String aboutHow() {
        return "about/aboutHow";
    }

    @RequestMapping("/aboutPublications")
    String aboutPublications() {
        return "about/aboutPublications";
    }

}
