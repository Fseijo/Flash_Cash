package com.seijo.flashCash.controller;

import com.seijo.flashCash.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class ProfileController {

    private final UserAccountService accountService;

    @GetMapping("/profile")
    public ModelAndView showProfilePage(Model model){
        return new ModelAndView("profile/profile");
    }
}
