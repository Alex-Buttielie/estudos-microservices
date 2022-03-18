package br.com.erudio.services;

import br.com.erudio.utils.NumberConverterUtil;
import br.com.erudio.validations.ValidationOperations;

public class Multiplication {

    public static Double multiplicationOperation(String numberOne, String numberTwo){
        ValidationOperations.validateNumbersOperation(numberOne, numberTwo);
        return performsMultiplication(numberOne, numberTwo);
    }

    private static Double performsMultiplication(String numberOne, String numberTwo){
        return NumberConverterUtil.convertDouble(numberOne) * NumberConverterUtil.convertDouble(numberTwo);
    }

}
