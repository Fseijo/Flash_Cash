package com.seijo.flashCash.controller;

import com.seijo.flashCash.auth.AuthenticationService;
import com.seijo.flashCash.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

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
    public ModelAndView processRequestRegister(@ModelAttribute("registerForm") RegisterRequest request) {
        authenticationService.register(request);
        return new ModelAndView("signin");
    }
    @GetMapping("/home")
    public ModelAndView home(Model model){
        return new ModelAndView("home");
    }
}
