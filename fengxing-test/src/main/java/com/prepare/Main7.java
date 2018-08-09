package com.prepare;

/**
 * Created by sunfei on 2018/6/27.
 */

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Main7 {

    public static void main(String[] args) {
        Main7 main = new Main7();
        System.out.println(main.RectCover(100));
    }

    public int RectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return RectCover(target-2) + RectCover(target-1);
    }
}
