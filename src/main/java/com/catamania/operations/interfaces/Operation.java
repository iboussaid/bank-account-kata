package com.catamania.operations.interfaces;
import java.time.LocalDateTime;

public interface Operation {
    Float amount();

    LocalDateTime date();

    Float calculateNewBalance(Float balance);
}
