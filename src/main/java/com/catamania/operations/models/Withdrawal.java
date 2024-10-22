package com.catamania.operations.models;

import com.catamania.operations.interfaces.Operation;

import java.time.LocalDateTime;

public record Withdrawal(Float amount, LocalDateTime date) implements Operation {
    @Override
    public Float calculateNewBalance(Float balance) {
        return balance - amount;
    }
}
