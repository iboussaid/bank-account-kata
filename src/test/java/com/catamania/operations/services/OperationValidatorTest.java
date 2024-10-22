package com.catamania.operations.services;

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
        Operation validDeposit = new Withdrawal(100f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        boolean result = operationValidator.validateOperation(validDeposit);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("my withdrawal should have a positive value - case with negative value")
    void testWithInValidWithdrawal() {
        Operation invalidDeposit = new Withdrawal(-100f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        boolean result = operationValidator.validateOperation(invalidDeposit);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("my balance should be positive after withdrawal - case with enough funds")
    void testWhenBalanceIsSufficient() {
        boolean result = operationValidator.validateBalance(100f, 50f);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("my balance should be positive after withdrawal - case with insufficient funds")
    void testWhenBalanceIsInsufficient() {
        boolean result = operationValidator.validateBalance(100f, 500f);
        Assertions.assertFalse(result);
    }
}
