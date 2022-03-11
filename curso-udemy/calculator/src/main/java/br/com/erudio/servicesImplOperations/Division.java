package br.com.erudio.servicesImplOperations;

import br.com.erudio.utils.ConverterStrToDoubleUtils;
import br.com.erudio.validations.ValidationOperations;

public class Subtraction {

    public static Double subtraction(String numberOne, String numberTwo){
        ValidationOperations.validateNumbersOperation(numberOne, numberTwo);
        return performsSubtraction(numberOne, numberTwo);
    }

    private static Double performsSubtraction(String numberOne, String numberTwo){
        return ConverterStrToDoubleUtils.convertDouble(numberOne) - ConverterStrToDoubleUtils.convertDouble(numberTwo);
    }

}
