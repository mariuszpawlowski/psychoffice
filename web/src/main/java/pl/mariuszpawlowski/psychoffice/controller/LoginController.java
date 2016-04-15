package pl.psychoffice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by mario on 20/08/15.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    String admin() {
        return "login";
    }

    @RequestMapping(value = "/login2", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        return new ModelAndView("login2", "error", error);
    }


}
