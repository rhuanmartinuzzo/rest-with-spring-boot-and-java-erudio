package br.com.erudio.math;



public class SimpleMath {
    public Double sum( Double numberOne, Double numberTwo){
        return numberOne + numberTwo;
    }

    public Double minus(Double numberOne, Double numberTwo){
        return numberOne - numberTwo;
    }

    public Double multiply(Double numberOne, Double numberTwo){
        return numberOne * numberTwo;
    }

    public Double division(Double numberOne, Double numberTwo){
        return numberOne / numberTwo;
    }

    public Double mean(Double numberOne, Double numberTwo){
        return (numberOne + numberTwo)/ 2;
    }

    public Double sqrt(Double numberOne){
        return Math.sqrt((numberOne));
    }
}
