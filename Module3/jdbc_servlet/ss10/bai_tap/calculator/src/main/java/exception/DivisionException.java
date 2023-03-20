package exception;

import java.util.Stack;

public class DivisionException extends Exception {
    String errorLine;

    public DivisionException(String errorLine) {
        this.errorLine = errorLine;
    }

    @Override
    public String getMessage() {
        return errorLine;
    }

    public static String checkValue2(String value2) throws DivisionException{
        if(value2.equalsIgnoreCase("0")) throw new  DivisionException("No value 2 in 0");
        return "";
    }

}
