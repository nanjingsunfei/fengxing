package com.prepare;

/**
 * Created by sunfei on 2018/6/27.
 */

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Main8 {

    public int NumberOf1(int n) {

        int count = 0;
        while(n != 0) {
            count ++;
            n = n & (n-1);
        }
        return count;
    }
}
