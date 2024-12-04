package by.tms.projectfootdairy.controller;

import by.tms.projectfootdairy.entity.DayPlan;
import by.tms.projectfootdairy.entity.User;
import by.tms.projectfootdairy.service.DayPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dayPlan")
public class DayPlanController {

    @Autowired
    private DayPlanService dayPlanService;

    @GetMapping
    public String dayPlan(@AuthenticationPrincipal User user, Model model) {

//        SecurityContext context = SecurityContextHolder.getContext();
//        Authentication authentication = context.getAuthentication();
//
        try {
            DayPlan dayPlan = dayPlanService.findById(user.getId());
            model.addAttribute("calories_currently", dayPlan.getCalories());
        } catch (Exception e) {
            model.addAttribute("calories_currently", " текущий план не установлен ");
        }

        model.addAttribute("dayPlan", new DayPlan());

        return "dayPlan";
    }

    @PostMapping
    public String addDayPlan(@ModelAttribute("dayPlan") DayPlan dayPlan) {
        dayPlanService.save(dayPlan);
        return "redirect:/dayPlan";
    }
}
