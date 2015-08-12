package pl.psychoffice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mario on 12/08/15.
 */
@Controller
public class AboutController {

    @RequestMapping("/about")
    String about() {
        return "about";
    }
}
