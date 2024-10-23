package com.catamania.operations.services;

import com.catamania.accounts.models.Account;
import com.catamania.operations.interfaces.StatementInterface;
import com.catamania.operations.interfaces.Operation;
import com.catamania.operations.models.Deposit;
import com.catamania.operations.models.Withdrawal;
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
    StatementInterface historyOperations;

    @BeforeEach
    void setUp() {
        operationValidator = Mockito.mock(OperationValidator.class);
        when(operationValidator.validateOperation(any(Operation.class))).thenReturn(true);
        historyOperations = new Operations(operationValidator);
    }

    @Test
    @DisplayName("In order to check my operations As a bank client I want to see the history (operation, date, amount, balance) of my operations")
    void checkOperations() {
        Account clientAccount = new Account();
        Operation firstDeposit = new Deposit(100f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        Operation secondDeposit = new Deposit(100f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        Operation thirdDeposit = new Deposit(100f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        Operation firstWithdrawal = new Withdrawal(10f, LocalDateTime.of(2024, Month.OCTOBER, 23, 12, 0, 0));
        Operation secondWithdrawal = new Withdrawal(100f, LocalDateTime.of(2024, Month.OCTOBER, 23, 12, 0, 0));
        clientAccount.addOperation(firstDeposit);
        clientAccount.addOperation(secondDeposit);
        clientAccount.addOperation(thirdDeposit);
        clientAccount.addOperation(firstWithdrawal);
        clientAccount.addOperation(secondWithdrawal);
        clientAccount.setBalance(190f);
        String result = historyOperations.accountStatement(clientAccount);

        Assertions.assertEquals("Account{balance=190.0, operations=[Operation: Deposit {date=2024-10-22T12:00, amount=100.0}, Operation: Deposit {date=2024-10-22T12:00, amount=100.0}, Operation: Deposit {date=2024-10-22T12:00, amount=100.0}, Operation: Withdrawal{date=2024-10-23T12:00, amount=10.0}, Operation: Withdrawal{date=2024-10-23T12:00, amount=100.0}]}", result);
    }
}