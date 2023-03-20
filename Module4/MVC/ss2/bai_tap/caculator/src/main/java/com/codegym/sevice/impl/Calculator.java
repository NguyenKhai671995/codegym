package com.codegym.sevice.impl;

import com.codegym.sevice.ICalculator;
import org.springframework.stereotype.Service;

@Service
public class Calculator implements ICalculator {
    @Override
    public String getvalue(Double num1, Double num2, String calculator) {
        switch (calculator) {
            case "add":
                return  String.valueOf(num1 + num2);
            case "sub":
                return String.valueOf(num1 - num2);
            case "multi":
                return String.valueOf(num1 * num2);
            case "division":
                return num2 == 0 ? "Cannot division to zero" : String.valueOf(num1 / num2);
        }
        return null;
    }
}
