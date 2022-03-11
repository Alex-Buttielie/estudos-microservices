package br.com.erudio.servicesImpl;

import br.com.erudio.exception.UnsuportMathOperationException;
import br.com.erudio.utils.ConverterStrToDoubleUtils;
import br.com.erudio.utils.OperationsUtils;
import br.com.erudio.validations.ValidationNumber;

public class Sum {

    public static Double sum(String numberOne, String numberTwo){
        OperationsUtils.validateNumbersOperation(numberOne, numberTwo);
        return performsSum(numberOne, numberTwo);
    }

    private static Double performsSum(String numberOne, String numberTwo){
        return ConverterStrToDoubleUtils.convertDouble(numberOne) + ConverterStrToDoubleUtils.convertDouble(numberTwo);
    }

}
