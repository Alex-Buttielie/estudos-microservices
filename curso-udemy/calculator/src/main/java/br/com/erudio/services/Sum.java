package br.com.erudio.services;

import br.com.erudio.utils.NumberConverterUtil;
import br.com.erudio.validations.ValidationOperations;

public class Sum {

    public static Double sumOperation(String numberOne, String numberTwo){
        ValidationOperations.validateNumbersOperation(numberOne, numberTwo);
        return performsSum(numberOne, numberTwo);
    }

    private static Double performsSum(String numberOne, String numberTwo){
        return NumberConverterUtil.convertDouble(numberOne) + NumberConverterUtil.convertDouble(numberTwo);
    }

}
