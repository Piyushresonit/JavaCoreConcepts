package com.resonit.exceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingTryCatch {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            long value1 = in.nextInt();
            int value2 = in.nextInt();
            System.out.println(value1/value2);
        }
        catch (InputMismatchException exception){
            System.out.println(exception.getClass().getName());
        }
        catch (ArithmeticException exception) {
            System.out.println(exception);
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
        finally {
            System.out.println("Code executed");
        }
    }
}
