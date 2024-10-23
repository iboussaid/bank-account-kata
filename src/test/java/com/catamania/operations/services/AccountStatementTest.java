package com.catamania.operations.services;

import com.catamania.accounts.models.Account;
import com.catamania.operations.interfaces.HistoryInterface;
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

class AccountStatementTest {
    OperationValidator operationValidator;
    HistoryInterface historyOperations;

    @BeforeEach
    void setUp() {
        operationValidator = Mockito.mock(OperationValidator.class);
        when(operationValidator.validateOperation(any(Operation.class))).thenReturn(true);
        historyOperations = new Operations(operationValidator);
    }

    @Test
    @DisplayName("In order to check my operations As a bank client I want to see the history (operation, date, amount, balance) of my operations")
    void makeAnAccountStatement() {
        Account clientAccount = new Account();
        Operation depositOperation = new Deposit(100f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        Operation depositOperation2 = new Deposit(100f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        Operation depositOperation3 = new Deposit(100f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        Operation withdrawalOperation = new Deposit(10f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        Operation withdrawalOperation2 = new Deposit(100f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        clientAccount.addOperation(depositOperation);
        clientAccount.addOperation(depositOperation2);
        clientAccount.addOperation(depositOperation3);
        clientAccount.addOperation(withdrawalOperation);
        clientAccount.addOperation(withdrawalOperation2);
        String result = historyOperations.accountStatement(clientAccount);

        Assertions.assertEquals("TODO", result);
    }
}