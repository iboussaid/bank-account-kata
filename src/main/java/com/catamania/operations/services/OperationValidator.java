package com.catamania.operations.services;

import com.catamania.operations.enums.OperationType;
import com.catamania.operations.interfaces.Operation;

public class OperationValidator {
    public boolean validateOperation(Operation operation) {
        return operation != null && !isDepositWithNegativeAmount(operation);
    }

    private boolean isDepositWithNegativeAmount(Operation operation) {
        return OperationType.DEPOSIT.equals(operation.type()) && operation.amount() <= 0;
    }
}
