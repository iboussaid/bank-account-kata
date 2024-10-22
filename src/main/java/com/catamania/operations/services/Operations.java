package com.catamania.operations.services;

import com.catamania.operations.interfaces.DepositInterface;
import com.catamania.accounts.models.Account;
import com.catamania.operations.interfaces.WithdrawalInterface;
import com.catamania.operations.models.Deposit;
import com.catamania.operations.models.Withdrawal;

public class Operations implements DepositInterface, WithdrawalInterface {
    private final OperationValidator operationValidator;

    public Operations(OperationValidator operationValidator) {
        this.operationValidator = operationValidator;
    }

    @Override
    public boolean makeDeposit(Deposit deposit, Account account) {
        return operationValidator.validateOperation(deposit) && account.addOperation(deposit);
    }

    @Override
    public boolean makeWithdrawal(Withdrawal deposit, Account account) {
        return false;
    }
}
