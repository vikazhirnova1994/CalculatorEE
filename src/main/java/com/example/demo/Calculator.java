package com.example.demo;

import javax.enterprise.context.RequestScoped;

/**
 * @author Victoria Zhirnova
 * @project CalculatorEE
 */

@RequestScoped
public class Calculator {
    public Double sum (String a, String b) {
        return Double.valueOf(a) + Double.valueOf(b);
    }
    public Double subtract  (String a, String b) {
        return Double.valueOf(a) - Double.valueOf(b);
    }
    public Double divide (String a, String b) {
        return Double.valueOf(a) / Double.valueOf(b);
    }
    public Double multiply (String a, String b) {
        return Double.valueOf(a) * Double.valueOf(b);
    }
    public Double pow (String a, String b) {
        return Math.pow(Double.valueOf(a), Double.valueOf(b));
    }
}
