package service;

import exception.DivisionException;

public class Calculator {
    public static String getResult(String value1, String value2, String calculator) {
        switch (calculator) {
            case "add": {
                return String.format("result: %s + %s = %d", value1, value2, Integer.parseInt(value1) + Integer.parseInt(value2));
            }
            case "sub": {
                return String.format("result: %s - %s = %d", value1, value2, Integer.parseInt(value1) - Integer.parseInt(value2));
            }
            case "multi": {
                return String.format("result: %s * %s = %d", value1, value2, Integer.parseInt(value1) * Integer.parseInt(value2));
            }
            default:
                try {
                    DivisionException.checkValue2(value2);
                } catch (DivisionException e) {
                    return e.getMessage();
                }
                return String.format("result: %s / %s = %.3f", value1, value2, Double.parseDouble(value1) / Double.parseDouble(value2));
        }
    }
}
