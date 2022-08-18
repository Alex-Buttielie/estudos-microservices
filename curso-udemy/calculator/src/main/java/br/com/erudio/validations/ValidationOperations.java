package br.com.erudio.validations;

import br.com.erudio.exception.UnsuportMathOperationException;

public class ValidationOperations {
    public static void validateNumbersOperation(String... Numbers) {
        if (!ValidationNumbers.isNumeric(Numbers)) {
            throw new UnsuportMathOperationException("Please set a numeric value");
        }
    }
}
