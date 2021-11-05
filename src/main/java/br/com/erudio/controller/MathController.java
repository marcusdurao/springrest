package br.com.erudio.controller;

import br.com.erudio.exception.OperationException;
import br.com.erudio.math.SimpleMath;
import br.com.erudio.util.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new OperationException("Por favor entre com um valor numérico.");
        }
        Double v1 = NumberConverter.covertToDouble(numberOne);
        Double v2 = NumberConverter.covertToDouble(numberTwo);
        return math.sum(v1, v2);
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new OperationException("Por favor entre com um valor numérico.");
        }
        Double v1 = NumberConverter.covertToDouble(numberOne);
        Double v2 = NumberConverter.covertToDouble(numberTwo);
        return math.subtraction(v1, v2);
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new OperationException("Por favor entre com um valor numérico.");
        }
        Double v1 = NumberConverter.covertToDouble(numberOne);
        Double v2 = NumberConverter.covertToDouble(numberTwo);
        return math.multiplication(v1, v2);
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new OperationException("Por favor entre com um valor numérico.");
        }
        Double v1 = NumberConverter.covertToDouble(numberOne);
        Double v2 = NumberConverter.covertToDouble(numberTwo);
        return math.division(v1, v2);
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new OperationException("Por favor entre com um valor numérico.");
        }
        Double v1 = NumberConverter.covertToDouble(numberOne);
        Double v2 = NumberConverter.covertToDouble(numberTwo);
        return math.mean(v1, v2);
    }

    @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable("number") String number) {
        if (!NumberConverter.isNumeric(number) || !NumberConverter.isNumeric(number)) {
            throw new OperationException("Por favor entre com um valor numérico.");
        }
        Double v1 = NumberConverter.covertToDouble(number);

        return math.squareRoot(v1);
    }

}
