package com.catamania.operations.services;

import com.catamania.operations.interfaces.DepositInterface;
import com.catamania.accounts.models.Account;
import com.catamania.operations.interfaces.HistoryInterface;
import com.catamania.operations.interfaces.Operation;
import com.catamania.operations.interfaces.WithdrawalInterface;
import com.catamania.operations.models.Deposit;
import com.catamania.operations.models.Withdrawal;

public class Operations implements DepositInterface, WithdrawalInterface, HistoryInterface {
    private final OperationValidator operationValidator;

    public Operations(OperationValidator operationValidator) {
        this.operationValidator = operationValidator;
    }

    @Override
    public boolean makeDeposit(Deposit deposit, Account account) {
        if (operationValidator.validateOperation(deposit)) {
            return applyOperationToAccount(deposit, account);
        }
        return false;
    }

    @Override
    public boolean makeWithdrawal(Withdrawal withdrawal, Account account) {
        if (operationValidator.validateOperation(withdrawal) && operationValidator.validateBalance(account.getBalance(), withdrawal.amount())) {
            return applyOperationToAccount(withdrawal, account);
        }
        return false;
    }

    private boolean applyOperationToAccount(Operation operation, Account account) {
        Float balance = operation.calculateNewBalance(account.getBalance());
        account.setBalance(balance);
        return account.addOperation(operation);
    }

    @Override
    public String accountStatement(Account clientAccount) {
        return clientAccount.toString();
    }
}
