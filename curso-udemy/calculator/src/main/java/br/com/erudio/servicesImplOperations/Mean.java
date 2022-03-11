package br.com.erudio.servicesImplOperations;

import br.com.erudio.utils.ConverterStrToDoubleUtils;
import br.com.erudio.validations.ValidationOperations;

public class Mean {

    public static Double meanOperation(String numberOne, String numberTwo){
        ValidationOperations.validateNumbersOperation(numberOne, numberTwo);
        return performsSMean(numberOne, numberTwo);
    }

    private static Double performsSMean(String numberOne, String numberTwo){
        return ConverterStrToDoubleUtils.convertDouble(numberOne) + ConverterStrToDoubleUtils.convertDouble(numberTwo)/2;
    }

}
