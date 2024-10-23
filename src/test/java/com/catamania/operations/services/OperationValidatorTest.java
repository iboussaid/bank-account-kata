package com.catamania.operations.services;

import com.catamania.accounts.models.Account;
import com.catamania.operations.interfaces.Operation;
import com.catamania.operations.models.Deposit;
import com.catamania.operations.models.Withdrawal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

class OperationValidatorTest {
    OperationValidator operationValidator = new OperationValidator();

    @Test
    @DisplayName("my deposit should have a positive value - Nominal case")
    void testWithValidDeposit() {
        Operation validDeposit = new Deposit(100f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        boolean result = operationValidator.validateOperation(validDeposit);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("my deposit should have a positive value - case with negative value")
    void testWithInValidDeposit() {
        Operation invalidDeposit = new Deposit(-100f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        boolean result = operationValidator.validateOperation(invalidDeposit);
        Assertions.assertFalse(result);
    }


    @Test
    @DisplayName("my withdrawal should have a positive value - Nominal case")
    void testWithValidWithdrawal() {
        Operation validWithdrawal = new Withdrawal(100f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        boolean result = operationValidator.validateOperation(validWithdrawal);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("my withdrawal should have a positive value - case with negative value")
    void testWithInValidWithdrawal() {
        Operation invalidWithdrawal = new Withdrawal(-100f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        boolean result = operationValidator.validateOperation(invalidWithdrawal);
        Assertions.assertFalse(result);
    }
    @Test
    @DisplayName("my operation should not be null")
    void testWithNullOperation() {
        boolean result = operationValidator.validateOperation(null);
        Assertions.assertFalse(result);
    }
    @Test
    @DisplayName("my balance should be positive after withdrawal - case with enough funds")
    void testWhenBalanceIsSufficient() {
        Withdrawal withdrawal = new Withdrawal(50f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        Account clientAccount= new Account();
        clientAccount.setBalance(100f);
        boolean result = operationValidator.isWithdrawalPossibleForThisAccount(withdrawal, clientAccount);
        Assertions.assertTrue(result);
    }
    @Test
    @DisplayName("my balance should be zero after withdrawal - case with amount equals to funds")
    void testWhenBalanceIsSufficient_amountEqualToFunds() {
        Withdrawal withdrawal = new Withdrawal(100f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        Account clientAccount= new Account();
        clientAccount.setBalance(100f);
        boolean result = operationValidator.isWithdrawalPossibleForThisAccount(withdrawal, clientAccount);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("my balance should be positive after withdrawal - case with insufficient funds")
    void testWhenBalanceIsInsufficient() {
        Withdrawal withdrawal = new Withdrawal(500f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        Account clientAccount= new Account();
        clientAccount.setBalance(100f);
        boolean result = operationValidator.isWithdrawalPossibleForThisAccount(withdrawal, clientAccount);
        Assertions.assertFalse(result);
    }
}
