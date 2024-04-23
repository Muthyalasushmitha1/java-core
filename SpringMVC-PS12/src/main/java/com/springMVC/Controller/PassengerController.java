package com.springMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springMVC.Repository.PassengerDetails;

@Controller
@RestController("/passenger")
public class PassengerController {
    
    @GetMapping("/form")
    public String showPassengerForm(Model model) {
        model.addAttribute("passenger", new PassengerDetails());
        return "passengerForm";
    }
    
    @PostMapping("/register")
    public String registerPassenger(@ModelAttribute("passenger") PassengerDetails passenger) {
        // Logic to process registration
        return "redirect:/home";
    }
}
