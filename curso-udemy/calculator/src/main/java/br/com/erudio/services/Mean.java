package br.com.erudio.services;

import br.com.erudio.utils.NumberConverterUtil;
import br.com.erudio.validations.ValidationOperations;

public class Mean {

    public static Double meanOperation(String numberOne, String numberTwo) {
        ValidationOperations.validateNumbersOperation(numberOne, numberTwo);
        return performsSMean(numberOne, numberTwo);
    }

    private static Double performsSMean(String numberOne, String numberTwo) {
        return NumberConverterUtil.convertDouble(numberOne) + NumberConverterUtil.convertDouble(numberTwo) / 2;
    }

}
