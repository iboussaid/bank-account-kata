package com.catamania.operations.interfaces;

import com.catamania.operations.enums.OperationType;

import java.time.LocalDateTime;

public interface Operation {
    Float amount();

    LocalDateTime date();

    OperationType type();
}
