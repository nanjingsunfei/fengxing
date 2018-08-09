package com.prepare;

/**
 * Created by sunfei on 2018/6/27.
 */
public class Main4 {
    public static void main(String[] args) {
        Main4 mian = new Main4();
        System.out.println(mian.Fibonacci(3));
    }
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int a = 0;
        int b  = 1;
        int sum = a + b;
        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
            sum += b;
        }
        return sum;
    }

}
