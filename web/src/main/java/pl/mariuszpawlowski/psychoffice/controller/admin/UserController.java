package pl.mariuszpawlowski.psychoffice.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.mariuszpawlowski.psychoffice.domain.form.UserCreateForm;
import pl.mariuszpawlowski.psychoffice.domain.validator.UserCreateFormValidator;
import pl.mariuszpawlowski.psychoffice.service.user.UserService;

import javax.validation.Valid;
import java.util.HashMap;

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
    @RequestMapping(value = "/admin/addClient", method = RequestMethod.GET)
    public ModelAndView addClientPage() {
        MenuStyles menuStyles = new MenuStyles();
        menuStyles.setShowAddClient(true);
        HashMap<String, Object> attributes = new HashMap<>();
        attributes.put("menuStyles", menuStyles);
        attributes.put("form", new UserCreateForm());

        return new ModelAndView("admin/addClient", attributes);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/addClient", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
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
}
