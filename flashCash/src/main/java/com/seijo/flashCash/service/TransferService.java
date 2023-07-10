package com.seijo.flashCash.service;

import com.seijo.flashCash.service.form.CreditAccountRequest;
import com.seijo.flashCash.service.form.TransferFormRequest;
import com.seijo.flashCash.service.form.TransferToBankFormRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final UserAccountService accountService;
    private final UserService userService;

    public void creditAccount(CreditAccountRequest request){
        accountService.saveAccount(userService.sessionUser().getAccount().plus(request.getAmount()));
    }

    public void transferToBank(TransferToBankFormRequest request) {
        accountService.saveAccount(userService.sessionUser().getAccount().minus(request.getAmount()));
    }

    public void transferToAnotherAccount(TransferFormRequest request) {

    }
}
