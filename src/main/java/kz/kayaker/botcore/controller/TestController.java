package kz.kayaker.botcore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("user")
    public String userTest() {
        return "user ok";
    }

    @GetMapping("admin")
    public String adminTest() {
        return "admin ok";
    }
}
