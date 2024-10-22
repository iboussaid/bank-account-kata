package com.catamania.operations.services;

import com.catamania.operations.models.Deposit;
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
        Deposit validDeposit = new Deposit(100f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        boolean result = operationValidator.validateOperation(validDeposit);
        Assertions.assertTrue(result);
    }
    @Test
    @DisplayName("my deposit should have a positive value - case with negative value")
    void testWithInValidDeposit() {
        Deposit invalidDeposit = new Deposit(-100f, LocalDateTime.of(2024, Month.OCTOBER, 22, 12, 0, 0));
        boolean result = operationValidator.validateOperation(invalidDeposit);
        Assertions.assertFalse(result);
    }
}
