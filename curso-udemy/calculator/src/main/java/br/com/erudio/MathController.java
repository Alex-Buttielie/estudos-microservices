package br.com.erudio;
import br.com.erudio.exception.UnsuportMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum (@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberOne)) {
            throw new UnsuportMathOperationException("Please set a numeric value");
        }
        Double sum  = convertDouble(numberOne) + convertDouble(numberTwo);
        return sum;
    }
    private Double convertDouble(String strNumber){
        if (strNumber == null)
            return 0D;
        String number = strNumber.replaceAll(",", ".");
        if(isNumeric(number))
            return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null)
            return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
