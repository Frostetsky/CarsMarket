package resource.service.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class ResourceServerController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello, I am Resource Server.";
    }
}
