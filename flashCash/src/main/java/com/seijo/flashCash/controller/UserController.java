package com.seijo.flashCash.controller;

import com.seijo.flashCash.auth.AuthenticationService;
import com.seijo.flashCash.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticationService;
    @GetMapping("/")
    public ModelAndView index(Model model){
        return new ModelAndView("index");
    }

    @GetMapping("/signup")
    public ModelAndView showRegisterForm(){
        return new ModelAndView("signup", "registerForm", new RegisterRequest());
    }

    @PostMapping("/signup")
    public ModelAndView processRequest(@ModelAttribute("registerForm") RegisterRequest request) {
        authenticationService.register(request);
        return new ModelAndView("signin");
    }
}
