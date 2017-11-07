package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by twx on 2017/8/30.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "helloworld";
    }
}
