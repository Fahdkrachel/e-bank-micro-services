package com.krachelfahd.bankaccountservice.dto;

import com.krachelfahd.bankaccountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor
@NoArgsConstructor
@Builder

public class BankAccountDTORequest {
    private Double balance;
    private String currency;
    private AccountType type;
}
