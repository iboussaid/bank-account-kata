package com.catamania.operations.interfaces;

import com.catamania.accounts.models.Account;

public interface HistoryInterface {
    String accountStatement(Account clientAccount);

    default void printStatement(Account clientAccount) {
        System.out.println(accountStatement(clientAccount));
    }
}
