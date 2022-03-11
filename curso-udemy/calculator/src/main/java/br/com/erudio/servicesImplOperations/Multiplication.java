package br.com.erudio.servicesImplOperations;

import br.com.erudio.utils.ConverterStrToDoubleUtils;
import br.com.erudio.validations.ValidationOperations;

public class Multiplication {

    public static Double multiplicationOperation(String numberOne, String numberTwo){
        ValidationOperations.validateNumbersOperation(numberOne, numberTwo);
        return performsMultiplication(numberOne, numberTwo);
    }

    private static Double performsMultiplication(String numberOne, String numberTwo){
        return ConverterStrToDoubleUtils.convertDouble(numberOne) * ConverterStrToDoubleUtils.convertDouble(numberTwo);
    }

}
