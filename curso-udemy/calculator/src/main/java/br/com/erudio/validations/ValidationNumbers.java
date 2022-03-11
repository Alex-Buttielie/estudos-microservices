package br.com.erudio.validations;

import java.util.Arrays;

public class ValidationNumbers {

    public static boolean isNumeric(String ...strNumbers) {
        if (strNumbers == null)
            return false;

        return Arrays
                .stream(strNumbers)
                .map(strNumber -> strNumber.replace(",", "."))
                .map(strNumber -> strNumber.matches("[-+]?[0-9]*\\.?[0-9]+"))
                .findAny()
                .orElse(false);

    }
}
