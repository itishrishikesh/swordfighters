package com.sword.fighers.swordfighters.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("login")
    public String login(String username, String password){
        return "login";
    }
}
