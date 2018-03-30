package pl.mariuszpawlowski.psychoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableEncryptableProperties
//@PropertySource(name = "EncryptedProperties", value = "classpath:encrypted.properties")
public class WebApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }

}
