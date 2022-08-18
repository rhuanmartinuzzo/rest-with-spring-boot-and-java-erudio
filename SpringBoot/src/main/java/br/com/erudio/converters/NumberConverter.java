package br.com.erudio.converters;

import static java.lang.Double.parseDouble;

public class NumberConverter {


    public static Double convertToDouble(String strNumber) {
        if(strNumber == null){
            return 0D;
        }
        String number = strNumber.replaceAll(",", ".");
        if(IsNumeric(number)){
            return parseDouble(number);
        }
        return 0D;
    }

    public static boolean IsNumeric(String strNumber) {
        if(strNumber == null){
            return false;
        }
        String number = strNumber.replaceAll(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }
}

