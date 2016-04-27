package pl.mariuszpawlowski.psychoffice.controller.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Mariusz.Pawlowski on 2015-08-11.
 */
@Controller
public class AdminController {

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/admin")
    public String admin() {
        return "admin/admin";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/admin/showClients")
    public String showClients(Model model) {
        return "admin/showClients";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/admin/showVisits")
    public ModelAndView showVisits() {
        return new ModelAndView("admin/showVisits");
    }


}
