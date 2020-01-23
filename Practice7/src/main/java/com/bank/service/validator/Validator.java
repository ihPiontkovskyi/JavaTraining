package com.bank.service.validator;

import com.bank.exception.InvalidFieldException;

public interface Validator<E> {
    void validate(E entity) throws InvalidFieldException;
}