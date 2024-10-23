package com.catamania.operations.services;


import com.catamania.accounts.models.Account;
import com.catamania.operations.interfaces.Operation;
import com.catamania.operations.interfaces.ServiceApi;
import com.catamania.operations.models.Deposit;
import com.catamania.operations.models.Withdrawal;

public class Operations implements ServiceApi {
    private final OperationValidator operationValidator;

    public Operations(OperationValidator operationValidator) {
        this.operationValidator = operationValidator;
    }

    @Override
    public boolean makeDeposit(Deposit deposit, Account account) {
        return operationValidator.validateOperation(deposit) && applyOperationToAccount(deposit, account);
    }

    @Override
    public boolean makeWithdrawal(Withdrawal withdrawal, Account account) {
        return operationValidator.isWithdrawalPossibleForThisAccount(withdrawal, account)
                && applyOperationToAccount(withdrawal, account);
    }

    @Override
    public String accountStatement(Account clientAccount) {
        return clientAccount.toString();
    }

    private boolean applyOperationToAccount(Operation operation, Account account) {
        Float balance = operation.calculateNewBalance(account.getBalance());
        account.setBalance(balance);
        return account.addOperation(operation);
    }
}
