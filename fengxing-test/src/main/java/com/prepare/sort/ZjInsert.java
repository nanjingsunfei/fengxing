package com.prepare.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by sunfei on 2018/6/29.
 */
public class ZjInsert {
    public static void main(String[] args) {
        ZjInsert main = new ZjInsert();
        int[] a = {2,4,1,6,9,5};
        main.zjInsert(a);

        System.out.println(JSONObject.toJSONString(a));
    }

    public void zjInsert(int[] a) {
        if (a.length == 0 || a.length == 1) {
            return;
        }
        int len = a.length;
        for (int i = 1; i < len; i++) {
            int temp = a[i];
            int j = i - 1;
            while (j > -1 && a[j] > temp) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }
    }
}
