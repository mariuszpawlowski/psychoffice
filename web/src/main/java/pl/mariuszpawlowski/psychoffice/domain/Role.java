package pl.mariuszpawlowski.psychoffice.domain;

/**
 * Created by mario on 15/04/16.
 */
public enum Role {
    USER("USER"),
    ADMIN("ADMIN");

    String value;

    Role(String value){
        this.value = value;
    }

}