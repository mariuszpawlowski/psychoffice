package pl.mariuszpawlowski.psychoffice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mario on 15/08/15.
 */
@Controller
public class BlogController {

    @RequestMapping("/blog")
    String blog(){
        return "blog";
    }

    @RequestMapping("/blog/1")
    String blog1(){
        return "blog/blog1";
    }
}
