package com.seijo.flashCash.controller;

import com.seijo.flashCash.service.TransferService;
import com.seijo.flashCash.service.form.CreditAccountRequest;
import com.seijo.flashCash.service.form.TransferToBankFormRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class TransferController {

    private final TransferService service;

    @GetMapping("/transfer")
    public ModelAndView showTransferPage(Model model){
        return new ModelAndView("transfer/transfer", "transferToBankForm", new TransferToBankFormRequest());
    }

    @PostMapping("/transfer")
    public ModelAndView processRequestTransferToBank(@ModelAttribute("transferToBankForm") TransferToBankFormRequest request){
        service.transferToBank(request);
        return new ModelAndView("home");
    }

    @GetMapping("/credit")
    public ModelAndView showCreditForm(Model model){
        return new ModelAndView("transfer/credit", "creditForm", new CreditAccountRequest());
    }

    @PostMapping("/credit")
    public ModelAndView processRequestCredit(@ModelAttribute("creditForm") CreditAccountRequest request){
        service.creditAccount(request);
        return new ModelAndView("home");
    }
}
