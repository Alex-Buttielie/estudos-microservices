package br.com.erudio.operations;

import br.com.erudio.utils.NumberConverterUtil;
import br.com.erudio.validations.ValidationOperations;

public class Division {

    public static Double divisionOperation(String numberOne, String numberTwo){
        ValidationOperations.validateNumbersOperation(numberOne, numberTwo);
        return performsSDivision(numberOne, numberTwo);
    }

    private static Double performsSDivision(String numberOne, String numberTwo){
        return NumberConverterUtil.convertDouble(numberOne) / NumberConverterUtil.convertDouble(numberTwo);
    }

}
