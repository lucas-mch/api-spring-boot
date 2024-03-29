package dev.lucasmachado.services;

import dev.lucasmachado.enterprise.security.UserSpringSecurity;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserService {

    public static UserSpringSecurity authenticated() {
        try {
            return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        catch (Exception e) {
            return null;
        }
    }
}