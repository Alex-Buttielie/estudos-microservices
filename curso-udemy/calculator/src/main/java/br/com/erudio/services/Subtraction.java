package br.com.erudio.services;

import br.com.erudio.utils.NumberConverterUtil;
import br.com.erudio.validations.ValidationOperations;

public class Subtraction {

    public static Double subtractionOperation(String numberOne, String numberTwo){
        ValidationOperations.validateNumbersOperation(numberOne, numberTwo);
        return performsSubtraction(numberOne, numberTwo);
    }

    private static Double performsSubtraction(String numberOne, String numberTwo){
        return NumberConverterUtil.convertDouble(numberOne) - NumberConverterUtil.convertDouble(numberTwo);
    }

}
