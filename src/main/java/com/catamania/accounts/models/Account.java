package com.catamania.accounts.models;

import com.catamania.operations.enums.OperationType;
import com.catamania.operations.interfaces.Operation;

import java.util.ArrayList;
import java.util.Collection;

public class Account {
    private float balance;
    private final Collection<Operation> operations;

    public Account() {
        this.balance = 0f;
        this.operations = new ArrayList<>();
    }
    public boolean addOperation(Operation operation) {
        if (OperationType.DEPOSIT.equals(operation.type())) {
            balance += operation.amount();
            return operations.add(operation);
        }
        return false;
    }

    public float getBalance() {
        return balance;
    }
}
