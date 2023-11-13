package com.banking.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banking.models.ApplicationUser;
import com.banking.models.DepositRequest;
import com.banking.models.PrimaryAccount;
import com.banking.models.PrimaryTransaction;
import com.banking.models.SavingsAccount;
import com.banking.models.SavingsTransaction;
import com.banking.services.AccountService;
import com.banking.services.TransactionService;
import com.banking.services.UserService;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/primaryAccount")
    public String primaryAccount(Model model, Principal principal) {
    	
    	ApplicationUser user = (ApplicationUser) userService.loadUserByUsername(principal.getName());
    	user.setPrimaryAccount(accountService.createPrimaryAccount());
    	
        List<PrimaryTransaction> primaryTransactionList = transactionService.findPrimaryTransactionList(principal.getName());

        PrimaryAccount primaryAccount = user.getPrimaryAccount();

        model.addAttribute("primaryAccount", primaryAccount);
        model.addAttribute("primaryTransactionList", primaryTransactionList);

        return "primaryAccount";
    }

    @RequestMapping("/savingsAccount")
    public String savingsAccount(Model model, Principal principal) {
    	ApplicationUser user = (ApplicationUser) userService.loadUserByUsername(principal.getName());
    	user.setSavingsAccount(accountService.createSavingsAccount());
        List<SavingsTransaction> savingsTransactionList = transactionService.findSavingsTransactionList(principal.getName());
        
        SavingsAccount savingsAccount = user.getSavingsAccount();

        model.addAttribute("savingsAccount", savingsAccount);
        model.addAttribute("savingsTransactionList", savingsTransactionList);

        return "savingsAccount";
    }

    @GetMapping("/deposit")
    public String deposit(Model model) {
        model.addAttribute("accountType", "");
        model.addAttribute("amount", "");

        return "deposit";
    }

   @PostMapping("/deposit")
    public String depositPOST(@RequestBody DepositRequest depositRequest, Principal principal) {
        accountService.deposit(depositRequest.getAccountType(),depositRequest.getAmount(), principal);

        return "redirect:/userFront";
    }

    @GetMapping("/withdraw")
    public String withdraw(Model model) {
        model.addAttribute("accountType", "");
        model.addAttribute("amount", "");

        return "withdraw";
    }

    @PostMapping("/withdraw")
    public String withdrawPOST(@RequestBody DepositRequest depositRequest, Principal principal) {
        accountService.withdraw(depositRequest.getAccountType(),depositRequest.getAmount(), principal);

        return "redirect:/userFront";
    }
}