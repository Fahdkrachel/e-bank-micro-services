package com.krachelfahd.bankaccountservice.services;

import com.krachelfahd.bankaccountservice.dto.BankAccountDTORequest;
import com.krachelfahd.bankaccountservice.dto.BankAccountDTOResponse;
import com.krachelfahd.bankaccountservice.entities.BankAcoount;

import java.util.List;

public interface AccountServices {
    BankAcoount createBankAcoount(BankAccountDTORequest bankAccount);
    List<BankAccountDTOResponse> getAllBankAccounts();
    BankAcoount getBankAccountId(String accountId);


}
