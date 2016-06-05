package pl.mariuszpawlowski.psychoffice.domain.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by mariusz.pawlowski on 2016-03-24.
 */
public class ContactForm {

    @Size(min=5, max=50)
    private String name;

    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String email;

    @Size(min=5, max=500)
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
