package com.catamania.operations.services;

import com.catamania.accounts.models.Account;
import com.catamania.operations.interfaces.DepositInterface;
import com.catamania.operations.interfaces.Operation;
import com.catamania.operations.models.Deposit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.time.Month;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

class DepositTest {
    OperationValidator operationValidator;
    DepositInterface depositOperations;

    @BeforeEach
    void setUp() {
        operationValidator = Mockito.mock(OperationValidator.class);
        when(operationValidator.validateOperation(any(Operation.class))).thenReturn(true);
        depositOperations = new Operations(operationValidator);
    }

    @Test
    @DisplayName("In order to save money as a bank client. I want to make a deposit in my account")
    void makeADepositOf100() {
        Account clientAccount = new Account();
        Deposit depositOperation = new Deposit(100f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        boolean result = depositOperations.makeDeposit(depositOperation, clientAccount);
        Assertions.assertTrue(result);
        Assertions.assertEquals(100f, clientAccount.getBalance());
    }
}