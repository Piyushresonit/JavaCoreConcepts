package com.resonit.basics;

import com.resonit.util.numberconverter.Converter;

public class Operators {

    public static void main(String[] args) {
        int number = 50;

        // Prefix Postfix Operators
        System.out.println("Postfix:" + number++);  // 10
        System.out.println(number);  // 11
        System.out.println("Prefix: " + ++number);  // 12

        // Shift Operators
        System.out.println("Binary: "+ Converter.decimalToBinary(number)); // 1100
        number = number >> 1;                       // Shift 1 bit towards right
        System.out.println("Right Shift >> "+ number);
        System.out.println("Binary: "+ Converter.decimalToBinary(number)); // 110
        number = number << 2;                       // Shift 2 bit towards left
        System.out.println("Left Shift << "+ number);
        System.out.println("Binary: "+ Converter.decimalToBinary(number)); // 11000
        number = number >>> 1;                       // Shift 1 bit towards right and leftmost bits filled with 0
        System.out.println("Shift right zero fill operator >>> "+ number);
        System.out.println("Binary: "+ Converter.decimalToBinary(number)); // 11000
        // Ternary Operator
        // boolean-expression ? true-expression : false-expression
        int num1 = 10;
        int num2 = 20;
        int maxOfTwoNumber = (num1 > num2) ? num1 : num2;
        System.out.println("Max: "+ maxOfTwoNumber);

    }


}
