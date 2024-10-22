package com.catamania.operations.models;

import com.catamania.operations.enums.OperationType;
import com.catamania.operations.interfaces.Operation;

import java.time.LocalDateTime;

import static com.catamania.operations.enums.OperationType.WITHDRAWAL;

public record Withdrawal(Float amount, LocalDateTime date) implements Operation {
    @Override
    public OperationType type() {
        return WITHDRAWAL;
    }
}
