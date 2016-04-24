package pl.mariuszpawlowski.psychoffice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mario on 15/08/15.
 */
@Controller
public class ClientController {

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping("/clientHome")
    public String clientHome(){
        return "client/clientHome";
    }

    @PreAuthorize("hasAuthority('USER')")
    @RequestMapping("/clientSessions")
    public String clientSesions(Authentication authentication){
        return "client/clientSessions";
    }


}
