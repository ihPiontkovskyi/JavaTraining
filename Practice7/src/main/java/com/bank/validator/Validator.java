package com.bank.validator;

import com.bank.exception.InvalidFieldException;

public interface Validator<E> {
    void validate(E entity) throws InvalidFieldException;
}