package com.company;
/*1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
        подаче массива другого размера необходимо бросить исключение MyArraySizeException.
        2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
        просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
        ячейке лежит символ или текст вместо числа), должно быть брошено исключение
        MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
        3 В методе main() вызвать полученный метод, обработать возможные исключения
        MyArraySizeException и MyArrayDataException и вывести результат расчета.
        */

import java.text.ParseException;

public class Main {
    static int numRow = 4;
    static int numCol = 4;
    static String sizeExcep = "MyArraySizeException";
    static String dataExep = "MyArrayDataException";

    public static void main(String[] args) {

        String [][] twoDimArray1 = { {"8","7","2","3"},{"7","0","1","12"}, {"8","7","2","3"},{"4","5","6","7"}};
        String [][] twoDimArray2 = { {"8","7","2","3"},{"7","0","1","12"}, {"8","7","2","3"}};
        String [][] twoDimArray3 = { {"8","7","2","3"},{"7","0","1","12"}, {"8","egjkjd","2","3"},{"4","5","6","7"}};


        try{
        System.out.println(sumArrConvert(twoDimArray1));
        System.out.println(sumArrConvert(twoDimArray2));

        }
        catch (MyArraySizeException e){

            System.out.println(e.getMessage());

        }
        catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try{
            System.out.println(sumArrConvert(twoDimArray3));

        }
        catch (MyArraySizeException e){

            System.out.println(e.getMessage());

        }
        catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }



    }
    public static int sumArrConvert(String[][] strArr) throws MyArraySizeException, MyArrayDataException{
        if ((strArr.length!= numRow)||(strArr[0].length!=numCol)) throw new MyArraySizeException(sizeExcep);
        int[][] intArr = new int[numRow][numCol];
        int sum=0;
        for (int row = 0; row<numRow; row++){
            for (int col=0; col<numCol; col++){
                try {
                    intArr[row][col] = Integer.parseInt(strArr[row][col]);
                }
                catch (NumberFormatException e){
                    throw new MyArrayDataException(dataExep, row,col);
                }
                sum+=intArr[row][col];
            }
        }
        return sum;
    }

}
