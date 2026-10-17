package com.krachelfahd.bankaccountservice.mappers;

import com.krachelfahd.bankaccountservice.dto.BankAccountDTOResponse;
import com.krachelfahd.bankaccountservice.entities.BankAcoount;
import org.springframework.beans.BeanUtils;

public class AcoountMapper {
    public BankAccountDTOResponse fromBankAccount(BankAcoount bankAccount){
        BankAccountDTOResponse bankAccountResponseDTO= new BankAccountDTOResponse();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
