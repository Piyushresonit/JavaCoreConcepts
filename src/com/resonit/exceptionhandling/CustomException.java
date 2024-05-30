package com.resonit.exceptionhandling;

// 1. Extends Exception class
public class CustomException extends Exception {
    public CustomException(String message){
        // 2. Call super(String message)
        super(message);
    }
}

class MyException{
    public static void main(String[] args) throws CustomException {
        int i = 12, j=0;
        try{
            double divide = i/j;
        }catch(Exception c){
            // 3. throw new CustomException(message)
            throw new CustomException("Divide by zero");
        }
    }
}
