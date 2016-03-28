package pl.mariuszpawlowski.psychoffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.mariuszpawlowski.psychoffice.component.mail.EmailStatus;
import pl.mariuszpawlowski.psychoffice.model.ContactForm;
import pl.mariuszpawlowski.psychoffice.service.MailSendService;

import java.io.UnsupportedEncodingException;

/**
 * Created by mario on 16/08/15.
 */
@Controller
public class ContactController {

    @Autowired
    private MailSendService mailSendService;

    @RequestMapping(value="/contact", method=RequestMethod.GET)
    String contact(Model model){
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }

    @RequestMapping(value="/contact", method= RequestMethod.POST)
    public String contactSubmit(@ModelAttribute ContactForm contactForm) {
        String resultTemplate;
        EmailStatus status = null;

        try {
            status = mailSendService.sendContactForm(contactForm.getName(), contactForm.getEmail(), contactForm.getMessage());
        } catch (UnsupportedEncodingException e) {
            resultTemplate = "contact/contactError";
        }

        if (status != null && status.isSuccess()) {
            resultTemplate = "contact/contactSent";
        } else {
            resultTemplate = "contact/contactError";
        }


        return resultTemplate;
    }
}
