package com.krachelfahd.bankaccountservice.services;

import com.krachelfahd.bankaccountservice.dto.BankAccountDTOResponse;
import com.krachelfahd.bankaccountservice.entities.BankAcoount;

import java.util.List;

public interface AccountServices {
    BankAcoount createBankAcoount(BankAcoount bankAccount);
    List<BankAccountDTOResponse> getAllBankAccounts();
    BankAcoount getBankAccountId(String accountId);


}
