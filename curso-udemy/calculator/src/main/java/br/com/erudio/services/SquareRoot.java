package br.com.erudio.service;

import br.com.erudio.utils.NumberConverterUtil;
import br.com.erudio.validations.ValidationOperations;

public class SquareRoot {

    public static Double squareRootOperation(String numberOne){
        ValidationOperations.validateNumbersOperation(numberOne);
        return performsSSquareRoot(numberOne);
    }

    private static Double performsSSquareRoot(String numberOne){
        return Math.sqrt(NumberConverterUtil.convertDouble(numberOne));
    }

}
