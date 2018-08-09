package com.prepare.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by sunfei on 2018/6/29.
 */
public class Mp {

    public static void main(String[] args) {
        Mp main = new Mp();
        int[] a = {2, 4, 1, 5, 6, 9, 5};
        main.mp(a);

        System.out.println(JSONObject.toJSONString(a));
    }

    public void mp(int[] a) {
        if (a.length == 0 || a.length == 1) {
            return;
        }
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            int k = 0;
            for (int j = 0; j < len-i-1; j++) {
                if (a[j + 1] < a[j]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    k = 1;
                }
            }
            if (k == 0) {
                break;
            }
        }
    }
}
