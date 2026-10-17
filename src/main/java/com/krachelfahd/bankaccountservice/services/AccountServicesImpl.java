package com.krachelfahd.bankaccountservice.services;


import com.krachelfahd.bankaccountservice.dto.BankAccountDTORequest;
import com.krachelfahd.bankaccountservice.dto.BankAccountDTOResponse;
import com.krachelfahd.bankaccountservice.entities.BankAcoount;
import com.krachelfahd.bankaccountservice.mappers.AcoountMapper;
import com.krachelfahd.bankaccountservice.repositories.BankAccountrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountServicesImpl {
    @Autowired
    private AcoountMapper acoountMapper;
    private final BankAccountrepository bankAccountRepo;
    public BankAccountDTOResponse addAccount(BankAccountDTORequest bankAccountDTO) {
        BankAcoount bankAccount = BankAcoount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();

        BankAcoount saveBankAccount = bankAccountRepo.save(bankAccount);
        BankAccountDTOResponse bankAccountDTOResponse = BankAccountDTOResponse.builder()
                .id(saveBankAccount.getId())
                .type(saveBankAccount.getType())
                .createdAt(saveBankAccount.getCreatedAt())
                .currency(saveBankAccount.getCurrency())
                .balance(saveBankAccount.getBalance())
                .build();

        return bankAccountDTOResponse;


    }

}


