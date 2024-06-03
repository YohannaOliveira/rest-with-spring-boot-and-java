package br.com.yohanna;

import br.com.yohanna.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class MathController {

    static final String MESSAGE_ERROR = "Please set a numeric value";

    //SOMA
    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException(MESSAGE_ERROR);
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    //SUBTRAÇÃO
    @GetMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException(MESSAGE_ERROR);
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    //MULTIPLICAÇÃO
    @GetMapping("/mult/{numberOne}/{numberTwo}")
    public Double mult(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException(MESSAGE_ERROR);
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    //DIVISÃO
    @GetMapping("/div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException(MESSAGE_ERROR);
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    //MÉDIA
    @GetMapping("/med/{numberOne}/{numberTwo}")
    public Double med(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException(MESSAGE_ERROR);
        }
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    //RAIZ QUADRADA
    @GetMapping("/raiz/{numberOne}")
    public Double raiz(@PathVariable(value = "numberOne") String numberOne){
        if (!isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException(MESSAGE_ERROR);
        }
        return Math.sqrt(convertToDouble(numberOne));
    }

    private Double convertToDouble(String strNumber) {
        if (Objects.isNull(strNumber)) {
            return 0D;
        }

        String number = strNumber.replace(",", ".");
        if (isNumeric(number)) {
            return Double.parseDouble(number);
        }
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (Objects.isNull(strNumber)) {
            return false;
        }
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?\\d*\\.?\\d+");
    }
}
