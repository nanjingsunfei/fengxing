package com.prepare.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by sunfei on 2018/6/30.
 */
public class Quick {

    public static void main(String[] args) {
        Quick quick = new Quick();
        int[] data = {6, 5, 9, 4, 10, 1};
        quick.quickSort(data, 0, data.length - 1);
        System.out.println(JSONObject.toJSONString(data));
    }

    public void quickSort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = partition(data, start, end);
        if (index > start) {
            quickSort(data, start, index - 1);
        }
        if (index < end) {
            quickSort(data, index + 1, end);
        }
    }

    public int partition(int[] data, int start, int end) {

        int temp = data[start];
        int index = start;

        for (int i = start + 1; i <= end; i++) {
            if (data[i] < temp) {
                swap(data, i, index);
                index ++;
            }
        }
        data[index] = temp;
        return index;

    }

    public void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
