package com.prepare;

/**
 * Created by sunfei on 2018/7/1.
 */
public class Main11 {

    public static void main(String[] args) {
        Main11 main = new Main11();
        main.print(2);
    }
    public void print(int n) {
        if (n <= 0) {
            return;
        }
        String[] number = new String[n];
        for (int i = 0; i < 10; i ++) {
            number[0] = String.valueOf(i);
            print(number, 0);
        }
    }

    public void print(String[] number, int index) {
        if (index == number.length - 1) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index + 1] = String.valueOf(i);
            print(number, index +1);
        }
    }

    public void printNumber(String[] number) {
        boolean isBegin0 = true;
        for (int i = 0; i < number.length; i++) {
            if (isBegin0 && !"0".equals(number[i])) {
                isBegin0 = false;
            }
            if (!isBegin0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }
}
