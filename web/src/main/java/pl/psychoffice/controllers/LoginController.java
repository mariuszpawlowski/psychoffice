package pl.psychoffice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mario on 20/08/15.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    String admin() {
        return "login";
    }


}
