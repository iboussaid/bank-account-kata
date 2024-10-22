package com.catamania.operations.services;

import com.catamania.accounts.models.Account;
import com.catamania.operations.interfaces.Operation;
import com.catamania.operations.models.Deposit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.time.Month;

import static org.mockito.Mockito.*;

class OperationsTest {
    @Mock
    OperationValidator operationValidator;
    @InjectMocks
    Operations operations;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        when(operationValidator.validateOperation(any(Operation.class))).thenReturn(true);
    }

    @Test
    @DisplayName("In order to save money as a bank client. I want to make a deposit in my account")
    void makeADepositOf100() {
        Account clientAccount = new Account();
        Deposit depositOperation = new Deposit(100f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        boolean result = operations.makeDeposit(depositOperation, clientAccount);
        Assertions.assertTrue(result);
        Assertions.assertEquals(100f, clientAccount.getBalance());
    }
}