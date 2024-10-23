package com.catamania.operations.services;

import com.catamania.accounts.models.Account;
import com.catamania.operations.interfaces.Operation;
import com.catamania.operations.models.Withdrawal;

/**
 * Help validating an operation on a bank account
 */
public class OperationValidator {

    private static final float ZERO = 0.0f;

    public boolean validateOperation(Operation operation) {
        //An operation should not be null or have a negative amount
        return operation != null && !isAmountNegative(operation);
    }

    public boolean isWithdrawalPossibleForThisAccount(Withdrawal withdrawal, Account account) {
        return validateOperation(withdrawal) && validateBalance(account.getBalance(), withdrawal.amount());
    }

    private boolean validateBalance(float balance, float amount) {
        //A balance should always be positive
        return balance - amount >= ZERO;
    }

    private boolean isAmountNegative(Operation operation) {
        return operation.amount() <= ZERO;
    }
}
