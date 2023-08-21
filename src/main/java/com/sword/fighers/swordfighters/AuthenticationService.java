package com.sword.fighers.swordfighters;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        return username.equals("admin@noemail.com") && password.equals("admin");
    }
}
