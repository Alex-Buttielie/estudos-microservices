package br.com.erudio.servicesImpl;

import br.com.erudio.exception.UnsuportMathOperationException;
import br.com.erudio.utils.ConverterStrToDoubleUtils;
import br.com.erudio.utils.OperationsUtils;
import br.com.erudio.validations.ValidationNumber;

public class Subtraction {

    public static Double subtraction(String numberOne, String numberTwo){
        OperationsUtils.validateNumbersOperation(numberOne, numberTwo);
        return performsSubtraction(numberOne, numberTwo);
    }

    private static Double performsSubtraction(String numberOne, String numberTwo){
        return ConverterStrToDoubleUtils.convertDouble(numberOne) + ConverterStrToDoubleUtils.convertDouble(numberTwo);
    }

}
