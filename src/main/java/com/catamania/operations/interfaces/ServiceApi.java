package com.catamania.operations.interfaces;

/**
 * Api that covers:
 * - Deposit and Withdrawal
 * - Account statement (date, amount, balance)
 * - Statement printing
 *
 * @see com.catamania.operations.interfaces.DepositInterface
 * @see com.catamania.operations.interfaces.WithdrawalInterface
 * @see com.catamania.operations.interfaces.StatementInterface
 */
public interface ServiceApi extends DepositInterface, StatementInterface, WithdrawalInterface {
}
