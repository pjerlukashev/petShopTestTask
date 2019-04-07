package lukashev.petshoptesttask.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class AppController {

    @GetMapping(value = "/hello")
    public String getHello() {
        return "hello";
    }


    @GetMapping(value = "/")
    public String getIndex() {
        return "index";
    }
}
