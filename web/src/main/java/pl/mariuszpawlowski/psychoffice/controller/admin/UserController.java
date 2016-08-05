package pl.mariuszpawlowski.psychoffice.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.mariuszpawlowski.psychoffice.domain.Role;
import pl.mariuszpawlowski.psychoffice.domain.jpa.User;
import pl.mariuszpawlowski.psychoffice.domain.validator.UserCreateFormValidator;
import pl.mariuszpawlowski.psychoffice.service.user.UserService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Mariusz.Pawlowski on 2016-06-10.
 */
@Controller
public class UserController {

    private final UserService userService;
    private final UserCreateFormValidator userCreateFormValidator;

    @Autowired
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/admin")
    public String admin(Model model) {
        MenuStyles menuStyles = new MenuStyles();
        menuStyles.setShowClients(true);
        model.addAttribute(menuStyles);
        List<User> clients = userService.getAllUsersWithRole(Role.USER);
        model.addAttribute("clients", clients);
        return "admin/showClients";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/admin/showClients")
    public ModelAndView showClients(Model model) {
        MenuStyles menuStyles = new MenuStyles();
        menuStyles.setShowClients(true);
        model.addAttribute(menuStyles);
        List<User> clients = userService.getAllUsersWithRole(Role.USER);
        model.addAttribute("clients", clients);
        return new ModelAndView("admin/showClients", "menuStyles", menuStyles);
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/addClient", method = RequestMethod.GET)
    public String addClientPage(Model model) {
        MenuStyles menuStyles = new MenuStyles();
        menuStyles.setShowAddClient(true);
        model.addAttribute("menuStyles", menuStyles);
        User form = new User();
        model.addAttribute("form", form);
        return "admin/addClient";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/addClient", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") User form, BindingResult bindingResult, Model model) {
        form.setRole(Role.USER);
        if (bindingResult.hasErrors()) {
            MenuStyles menuStyles = new MenuStyles();
            menuStyles.setShowAddClient(true);
            model.addAttribute("menuStyles", menuStyles);
            return "admin/addClient";
        }
        try {
            userService.save(form);
        } catch (Exception e) {
          //  bindingResult.reject("email.exists", "Email already exists");
            return "redirect:admin/addClient";
        }
        return "redirect:/admin/showClients";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/editClient/{id}", method = RequestMethod.GET)
    public String editClient(@PathVariable("id") User user, Model model) {
        MenuStyles menuStyles = new MenuStyles();
        menuStyles.setShowAddClient(true);
        model.addAttribute("menuStyles", menuStyles);
        model.addAttribute("form", user);
        return "admin/editClient";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/editClient", method = RequestMethod.POST)
    public String editClientSave(@Valid @ModelAttribute("form") User form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            MenuStyles menuStyles = new MenuStyles();
            menuStyles.setShowAddClient(true);
            model.addAttribute("menuStyles", menuStyles);
            return "admin/addClient";
        }
        try {
            userService.save(form);
        } catch (Exception e) {
            //  bindingResult.reject("email.exists", "Email already exists");
            return "redirect:admin/addClient";
        }
        return "redirect:/admin/showClients";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/deleteClient/{id}", method = RequestMethod.POST)
    public String deleteClient(@PathVariable("id") User user, Model model) {

        try {
            userService.delete(user);
        } catch (Exception e){
            return "redirect:/admin/showClients";
        }
        return "redirect:/admin/showClients";
    }


}
