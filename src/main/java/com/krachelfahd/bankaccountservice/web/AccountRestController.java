package com.krachelfahd.bankaccountservice.web;

import com.krachelfahd.bankaccountservice.dto.BankAccountDTORequest;
import com.krachelfahd.bankaccountservice.entities.BankAcoount;
import com.krachelfahd.bankaccountservice.repositories.BankAccountrepository;
import com.krachelfahd.bankaccountservice.services.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class AccountRestController {
    @Autowired
    private AccountServices bankAccountServices;
    private final BankAccountrepository bankAccountRepository;


    public AccountRestController(BankAccountrepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    @GetMapping("/bankAccounts")
    public List<BankAcoount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAcoount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account %s not found",id)));
    }
    @PostMapping("/bankAccounts")
    public BankAcoount save(@RequestBody BankAccountDTORequest bankAccountDTO) {

        return bankAccountServices.createBankAcoount(bankAccountDTO);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAcoount update(@PathVariable String id, @RequestBody BankAcoount bankAccount) {
        BankAcoount account = bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getBalance() != null) account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreatedAt() != null) account.setCreatedAt(new Date());
        if (bankAccount.getType() != null) account.setType(bankAccount.getType());
        if (bankAccount.getCurrency() != null) account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(account);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id) {
        bankAccountRepository.deleteById(id);
    }
}
