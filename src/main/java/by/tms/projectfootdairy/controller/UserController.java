package by.tms.projectfootdairy.controller;

import by.tms.projectfootdairy.entity.User;
import by.tms.projectfootdairy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String reg(Model model) {
        model.addAttribute("user", new User());

       return "reg";
    }

   @PostMapping ("/reg")
    public String reg(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/user/login";
   }

   @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

//   public ResponseEntity<User> createUser(@RequestBody User user) {
//        User save = userService.save(user);
//        return ResponseEntity.ok(save);
//   }
}
