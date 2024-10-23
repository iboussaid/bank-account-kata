package com.catamania.operations.interfaces;

/**
 * Represent a bank account operation transaction
 */
public interface Operation {
    Float amount();

    Float calculateNewBalance(Float balance);
}
