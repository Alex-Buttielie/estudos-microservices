package br.com.erudio.utils;

import br.com.erudio.validations.ValidationNumbers;

public class NumberConverterUtil {


    public static Double convertDouble(String strNumber){
        if (strNumber == null)
            return 0D;
        String number = strNumber.replaceAll(",", ".");
        if(ValidationNumbers.isNumeric(number))
            return Double.parseDouble(number);
        return 0D;
    }
}
