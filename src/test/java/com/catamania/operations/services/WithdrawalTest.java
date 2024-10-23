package com.catamania.operations.services;

import com.catamania.accounts.models.Account;
import com.catamania.operations.interfaces.Operation;
import com.catamania.operations.interfaces.WithdrawalInterface;
import com.catamania.operations.models.Deposit;
import com.catamania.operations.models.Withdrawal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.time.Month;

import static org.mockito.Mockito.*;

class WithdrawalTest {
    OperationValidator operationValidator;
    WithdrawalInterface withdrawalOperations;

    @BeforeEach
    void setUp() {
        operationValidator = Mockito.mock(OperationValidator.class);
        when(operationValidator.validateOperation(any(Operation.class))).thenReturn(true);
        when(operationValidator.validateBalance(any(Float.class), any(Float.class))).thenReturn(true);
        withdrawalOperations = new Operations(operationValidator);
    }

    @Test
    @DisplayName("In order to retrieve some of my savings As a bank client I want to make a withdrawal from my account")
    void makeAWithdrawalOf100() {
        Account clientAccount = new Account();
        clientAccount.setBalance(200f);
        Withdrawal depositOperation = new Withdrawal(100f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        boolean result = withdrawalOperations.makeWithdrawal(depositOperation, clientAccount);
        Assertions.assertTrue(result);
        Assertions.assertEquals(100f, clientAccount.getBalance());
    }

    @Test
    @DisplayName("In order to retrieve all of my savings As a bank client I want to make a withdrawal from my account")
    void makeAWithdrawalOfAllFunds() {
        when(operationValidator.validateBalance(any(Float.class), any(Float.class))).thenCallRealMethod();
        Account clientAccount = new Account();
        clientAccount.setBalance(200f);
        Withdrawal depositOperation = new Withdrawal(200f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        boolean result = withdrawalOperations.makeWithdrawal(depositOperation, clientAccount);
        Assertions.assertTrue(result);
        Assertions.assertEquals(0f, clientAccount.getBalance());
    }
}