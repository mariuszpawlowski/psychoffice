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
    public ModelAndView showClients(Model model) {
        MenuStyles menuStyles = new MenuStyles();
        menuStyles.setShowClients(true);
        model.addAttribute(menuStyles);

//        return "admin/showClients";
        return new ModelAndView("admin/showClients", "menuStyles", menuStyles);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/admin/showVisits")
    public ModelAndView showVisits() {
        MenuStyles menuStyles = new MenuStyles();
        menuStyles.setShowVisits(true);
        return new ModelAndView("admin/showVisits", "menuStyles", menuStyles);
    }


}
