package com.prepare;

/**
 * Created by sunfei on 2018/6/27.
 */

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Main5 {

    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor(target -1)  + JumpFloor(target -2) ;
    }

    public int JumpFloor2(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        int temp = 0;
        for (int i = 3; i < target; i++) {
            temp = second;
            second = first + second;
            first = temp;
        }
        return second;
    }
}
