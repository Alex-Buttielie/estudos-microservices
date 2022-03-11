package br.com.erudio.operations;

import br.com.erudio.utils.ConverterStrToDoubleUtils;
import br.com.erudio.validations.ValidationOperations;

public class Sum {

    public static Double sumOperation(String numberOne, String numberTwo){
        ValidationOperations.validateNumbersOperation(numberOne, numberTwo);
        return performsSum(numberOne, numberTwo);
    }

    private static Double performsSum(String numberOne, String numberTwo){
        return ConverterStrToDoubleUtils.convertDouble(numberOne) + ConverterStrToDoubleUtils.convertDouble(numberTwo);
    }

}
