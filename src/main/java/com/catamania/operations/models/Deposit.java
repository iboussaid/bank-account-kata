package com.catamania.operations.models;

import com.catamania.operations.enums.OperationType;
import com.catamania.operations.interfaces.Operation;

import java.time.LocalDateTime;

public record Deposit(Float amount, LocalDateTime date) implements Operation {
    @Override
    public OperationType type() {
        return OperationType.DEPOSIT;
    }
}
