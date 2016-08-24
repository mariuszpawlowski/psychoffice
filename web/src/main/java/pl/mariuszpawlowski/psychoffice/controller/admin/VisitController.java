package pl.mariuszpawlowski.psychoffice.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.mariuszpawlowski.psychoffice.domain.form.VisitForm;
import pl.mariuszpawlowski.psychoffice.domain.jpa.Visit;
import pl.mariuszpawlowski.psychoffice.service.user.UserService;
import pl.mariuszpawlowski.psychoffice.service.visit.VisitService;

/**
 * Created by Mariusz.Pawlowski on 2016-08-01.
 */
@Controller
public class VisitController {

    private final UserService userService;
    private final VisitService visitService;

    @Autowired
    public VisitController(UserService userService, VisitService visitService) {
        this.userService = userService;
        this.visitService = visitService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/admin/showVisits")
    public ModelAndView showVisits(Model model) {
        MenuStyles menuStyles = new MenuStyles();
        menuStyles.setShowVisits(true);
        model.addAttribute(menuStyles);
        Iterable<Visit> visits = visitService.getAllVisits();
        model.addAttribute("visits", visits);
        return new ModelAndView("admin/showVisits");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/addVisit", method = RequestMethod.GET)
    public String addVisit(Model model) {
        MenuStyles menuStyles = new MenuStyles();
        menuStyles.setShowAddVisit(true);
        model.addAttribute("menuStyles", menuStyles);
        VisitForm form = new VisitForm();
        model.addAttribute("form", form);
        return "admin/addVisit";

    }

}
