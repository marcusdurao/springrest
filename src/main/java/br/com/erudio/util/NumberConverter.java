package br.com.erudio.util;

import org.apache.commons.lang3.StringUtils;

public class NumberConverter {

    public static Double covertToDouble(String strNumber) {
        if (StringUtils.isEmpty(strNumber)) return 0d;

        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0d;
    }

    public static boolean isNumeric(String strNumber) {
        if (StringUtils.isEmpty(strNumber)) return false;

        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
