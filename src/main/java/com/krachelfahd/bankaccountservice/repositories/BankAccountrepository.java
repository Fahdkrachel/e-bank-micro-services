package com.krachelfahd.bankaccountservice.repositories;

import com.krachelfahd.bankaccountservice.entities.BankAcoount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountrepository extends JpaRepository<BankAcoount,String> {
}
