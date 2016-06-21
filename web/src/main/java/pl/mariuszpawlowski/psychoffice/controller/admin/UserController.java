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
import pl.mariuszpawlowski.psychoffice.domain.form.UserCreateForm;
import pl.mariuszpawlowski.psychoffice.domain.jpa.User;
import pl.mariuszpawlowski.psychoffice.domain.validator.UserCreateFormValidator;
import pl.mariuszpawlowski.psychoffice.service.user.UserService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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
        HashMap<String, Object> attributes = new HashMap<>();
        model.addAttribute("menuStyles", menuStyles);
        model.addAttribute("form", new UserCreateForm());
        return "admin/addClient";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/addClient", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            MenuStyles menuStyles = new MenuStyles();
            menuStyles.setShowAddClient(true);
            model.addAttribute("menuStyles", menuStyles);
            return "admin/addClient";
        }
        try {
            userService.create(form);
        } catch (Exception e) {
            bindingResult.reject("email.exists", "Email already exists");
            return "admin/addClient";
        }
        return "redirect:/admin/showClients";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/editClient", method = RequestMethod.GET)
    public String editClient(@RequestParam("id") String clientId, Model model) {
        MenuStyles menuStyles = new MenuStyles();
        menuStyles.setShowAddClient(true);
        model.addAttribute("menuStyles", menuStyles);


        Optional<User> user = userService.getUserById(Long.parseLong(clientId));
        UserCreateForm form = new UserCreateForm();
        form.setEmail(user.get().getEmail());
        form.setCity(user.get().getUserDetails().getCity());
        form.setName(user.get().getUserDetails().getName());
        form.setSurname(user.get().getUserDetails().getSurname());
        form.setPhone(user.get().getUserDetails().getPhone());
        form.setId(user.get().getId());
        model.addAttribute("form", form);
        return "admin/editClient";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/editClient", method = RequestMethod.POST)
    public String editClientSave(@Valid @ModelAttribute("form") UserCreateForm form, Model model) {

        Optional<User> user = userService.getUserById(form.getId());


        return "redirect:/admin/showClients";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/deleteClient", method = RequestMethod.GET)
    public String deleteClient(@RequestParam("id") String clientId, Model model) {

        return "";
    }


}
