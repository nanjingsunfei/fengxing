package com.prepare;

/**
 * Created by sunfei on 2018/6/27.
 */

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Main6 {

    public int JumpFloorII(int target) {
        int a[] = new int[target + 1];
        a[0] = 1;
        a[1] = 1;

        for (int i=2; i<= target; i++) {
            a[i] = 0;
            for (int j= 0; j< i; j++) {
                a[i] += a[j];
            }
        }
        return a[target];
    }
}
