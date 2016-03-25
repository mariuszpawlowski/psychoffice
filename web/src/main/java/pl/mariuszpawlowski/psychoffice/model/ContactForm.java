package pl.mariuszpawlowski.psychoffice.model;

/**
 * Created by mariusz.pawlowski on 2016-03-24.
 */
public class ContactForm {
    private String name;
    private String email;
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
