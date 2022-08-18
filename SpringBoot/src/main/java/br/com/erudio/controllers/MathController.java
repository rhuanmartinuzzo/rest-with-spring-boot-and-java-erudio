package br.com.erudio.controllers;


import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
    method= RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{

        if (!NumberConverter.IsNumeric(numberOne) || !NumberConverter.IsNumeric(numberTwo) ) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.sum(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/minus/{numberOne}/{numberTwo}",
            method= RequestMethod.GET)
    public Double minus(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{

        if (!NumberConverter.IsNumeric(numberOne) || !NumberConverter.IsNumeric(numberTwo) ) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.minus(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/multiply/{numberOne}/{numberTwo}",
            method= RequestMethod.GET)
    public Double multiply(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{

        if (!NumberConverter.IsNumeric(numberOne) || !NumberConverter.IsNumeric(numberTwo) ) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.multiply(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}",
            method= RequestMethod.GET)
    public Double division(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{

        if (!NumberConverter.IsNumeric(numberOne) || !NumberConverter.IsNumeric(numberTwo) ) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.division(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}",
            method= RequestMethod.GET)
    public Double mean(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    )throws Exception{

        if (!NumberConverter.IsNumeric(numberOne) || !NumberConverter.IsNumeric(numberTwo) ) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.mean(NumberConverter.convertToDouble(numberOne) , NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/sqrt/{numberOne}",
            method= RequestMethod.GET)
    public Double sqrt(
            @PathVariable(value = "numberOne") String numberOne
    )throws Exception{

        if (!NumberConverter.IsNumeric(numberOne) ) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return math.sqrt(NumberConverter.convertToDouble(numberOne));
    }





}
