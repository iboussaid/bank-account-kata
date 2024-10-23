package com.catamania.operations.interfaces;

import com.catamania.accounts.models.Account;
import com.catamania.operations.models.Deposit;

/**
 *
 */
public interface DepositInterface {
    boolean makeDeposit(Deposit deposit, Account account);
}
