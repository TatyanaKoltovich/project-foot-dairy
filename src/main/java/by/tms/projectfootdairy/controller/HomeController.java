package by.tms.projectfootdairy.controller;

import by.tms.projectfootdairy.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

@GetMapping
    public String home(@AuthenticationPrincipal User user) {
    System.out.println(user);

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        System.out.println(authentication.getPrincipal());
        System.out.println(authentication.getAuthorities());
        System.out.println(authentication.getDetails());
        System.out.println(authentication.getCredentials());


    return "home";
}

}
