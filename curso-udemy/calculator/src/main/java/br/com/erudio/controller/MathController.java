package br.com.erudio;
import br.com.erudio.exception.UnsuportMathOperationException;
import br.com.erudio.utils.ConverterStrToDoubleUtils;
import br.com.erudio.validations.ValidationNumber;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum (@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) {
        if (!ValidationNumber.isNumeric(numberOne) || !ValidationNumber.isNumeric(numberTwo)) {
            throw new UnsuportMathOperationException("Please set a numeric value");
        }
        Double result  = ConverterStrToDoubleUtils.ConverterStrToDoubleUtils.convertDouble(numberOne) + ConverterStrToDoubleUtils.ConverterStrToDoubleUtils.convertDouble(numberTwo);
        return result;
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction (@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) {
        if (!ValidationNumber.isNumeric(numberOne) || !ValidationNumber.isNumeric(numberTwo)) {
            throw new UnsuportMathOperationException("Please set a numeric value");
        }
        Double result  = ConverterStrToDoubleUtils.ConverterStrToDoubleUtils.convertDouble(numberOne) - ConverterStrToDoubleUtils.ConverterStrToDoubleUtils.convertDouble(numberTwo);
        return result;
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication (@PathVariable(value = "numberOne") String numberOne,
                               @PathVariable(value = "numberTwo") String numberTwo) {
        if (!ValidationNumber.isNumeric(numberOne) || !ValidationNumber.isNumeric(numberTwo)) {
            throw new UnsuportMathOperationException("Please set a numeric value");
        }
        Double result  = ConverterStrToDoubleUtils.convertDouble(numberOne) * ConverterStrToDoubleUtils.convertDouble(numberTwo);
        return result;
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division (@PathVariable(value = "numberOne") String numberOne,
                                  @PathVariable(value = "numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportMathOperationException("Please set a numeric value");
        }
        Double result  = ConverterStrToDoubleUtils.convertDouble(numberOne) / ConverterStrToDoubleUtils.convertDouble(numberTwo);
        return result;
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean (@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsuportMathOperationException("Please set a numeric value");
        }
        Double result  = ConverterStrToDoubleUtils.convertDouble(numberOne) + ConverterStrToDoubleUtils.convertDouble(numberTwo)/2;
        return result;
    }

    @RequestMapping(value = "/squareRoot/{numberOne}", method = RequestMethod.GET)
    public Double squareRoot (@PathVariable(value = "numberOne") String numberOne) {
        if (!isNumeric(numberOne)) {
            throw new UnsuportMathOperationException("Please set a numeric value");
        }
        Double result  = Math.sqrt(ConverterStrToDoubleUtils.convertDouble(numberOne));
        return result;
    }

}
