package com.catamania.operations.interfaces;

import com.catamania.accounts.models.Account;

/**
 * Prepare and print the history (operation, date, amount, balance) of a client account operations
 */
public interface StatementInterface {
    String accountStatement(Account clientAccount);

    default void printStatement(Account clientAccount) {
        System.out.println(accountStatement(clientAccount));
    }
}
