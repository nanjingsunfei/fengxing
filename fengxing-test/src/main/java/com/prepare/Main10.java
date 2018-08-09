package com.prepare;

/**
 * Created by sunfei on 2018/6/28.
 */

import com.alibaba.fastjson.JSONObject;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Main10 {

    public static void main(String[] args) {
        Main10 main = new Main10();
        int[] array = {35,7,8,3,5,9};
        main.reOrderArray2(array);
        System.out.println(JSONObject.toJSONString(array));
    }

    public void reOrderArray(int [] array) {
        int len = array.length;
        if (len == 0 || len == 1) {
            return;
        }

        for (int i = 0; i < len -1; i++) {
            int k = 0;
            for (int j= 0; j < len -i -1; j++) {
                if (((array[j] & 1) == 0) && ((array[j+1] & 1) == 1)) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    k++;
                }
            }
            if (k == 0) {
                break;
            }
        }

    }

    public void reOrderArray2(int [] array) {
        int len = array.length;
        if (len == 0 || len == 1) {
            return;
        }

        int index = 0;
        for (int i = 0; i < array.length; i ++) {
            if (array[i] % 3 != 0) {
                index = i;
                break;
            }
        }
        int j = index;
        for (int i = index; i< array.length; i++) {
            if (array[i] % 3 == 0) {
                swap(array, i, j);
                j++;
            }
        }

    }

    public void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


}
