package com.catamania.accounts.models;

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
        return operations.add(operation);
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
