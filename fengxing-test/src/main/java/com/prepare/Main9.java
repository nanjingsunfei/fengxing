package com.prepare;

/**
 * Created by sunfei on 2018/6/27.
 */

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Main9 {
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        int n = Math.abs(exponent);
        double result = Power(base, n>>1);
        result *= result;
        if ((n&1) != 0) {
            result *= base;
        }

        if (exponent < 0) {
            result = 1/result;
        }
        return result;
    }
}
