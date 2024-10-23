package com.catamania.operations.services;

import com.catamania.operations.interfaces.Operation;

public class OperationValidator {

    private static final float ZERO = 0.0f;

    public boolean validateOperation(Operation operation) {
        return operation != null && !isAmountNegative(operation);
    }

    public boolean validateBalance(float balance, float amount) {
        return balance - amount >= ZERO;
    }

    private boolean isAmountNegative(Operation operation) {
        return operation.amount() <= ZERO;
    }
}
