package br.com.erudio.operations;

import br.com.erudio.utils.ConverterStrToDoubleUtils;
import br.com.erudio.validations.ValidationOperations;

public class Division {

    public static Double divisionOperation(String numberOne, String numberTwo){
        ValidationOperations.validateNumbersOperation(numberOne, numberTwo);
        return performsSDivision(numberOne, numberTwo);
    }

    private static Double performsSDivision(String numberOne, String numberTwo){
        return ConverterStrToDoubleUtils.convertDouble(numberOne) / ConverterStrToDoubleUtils.convertDouble(numberTwo);
    }

}
