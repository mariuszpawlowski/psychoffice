package pl.psychoffice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mario on 15/08/15.
 */
@Controller
public class ClientController {

    @RequestMapping("/clientHome")
    String clientHome(){
        return "clientHome";
    }

}
