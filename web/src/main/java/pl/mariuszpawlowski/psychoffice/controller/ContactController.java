package pl.mariuszpawlowski.psychoffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mariuszpawlowski.psychoffice.model.ContactForm;

/**
 * Created by mario on 16/08/15.
 */
@Controller
public class ContactController {

    @RequestMapping(value="/contact", method=RequestMethod.GET)
    String contact(Model model){
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @RequestMapping(value="/contact", method= RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute ContactForm contactForm, Model model) {

        return "contactSent";
    }
}
