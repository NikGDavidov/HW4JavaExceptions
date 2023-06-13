package com.company;

public class MyArrayDataException extends RuntimeException {
   public  MyArrayDataException (String message,int row, int col){
       super (message + " in row " + row + " column " + col);
   }
}
