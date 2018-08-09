package com.prepare.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by sunfei on 2018/6/29.
 */
public class Hill {
    public static void main(String[] args) {
        Hill main = new Hill();
        int[] a = {2,4,1,5,6,9,5};
        main.hill(a);

        System.out.println(JSONObject.toJSONString(a));
    }

    public void hill(int[] a) {
        if (a.length == 0 || a.length == 1) {
            return;
        }
        int len = a.length;
        int d = len >> 1;
        while (d >= 1) {
            for (int i = d; i < len; i++) {
                int temp = a[i];
                int j = i - d;
                while (j > -1 && a[j] > temp) {
                    a[j+d] = a[j];
                    j = j - d;
                }
                a[j+d] = temp;
            }
            d = d >> 1;
        }

    }
}
