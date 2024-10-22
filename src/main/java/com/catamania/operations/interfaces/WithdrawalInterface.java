package com.catamania.operations.interfaces;

import com.catamania.accounts.models.Account;
import com.catamania.operations.models.Deposit;
import com.catamania.operations.models.Withdrawal;

public interface WithdrawalInterface {
    boolean makeWithdrawal(Withdrawal deposit, Account account);
}
