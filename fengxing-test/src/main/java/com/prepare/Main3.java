package com.prepare;

/**
 * Created by sunfei on 2018/6/27.
 */
public class Main3 {
    public static void main(String[] args) {
        Main3 main = new Main3();
        int[] array = {7,1,2,4,5};
        System.out.println(main.minNumberInRotateArray(array));
    }
    public int minNumberInRotateArray(int [] array) {

        if (array.length == 0) {
            return 0;
        }
        return minNumberInRotateArray(array, 0, array.length - 1);

    }

    public int minNumberInRotateArray(int [] array, int start, int end) {
        if (start == end) {
            return array[start];
        }
        int middle = (start + end) >> 1;
        if (array[start] > array[middle]) {
            return minNumberInRotateArray(array, start, middle);
        } else if (array[middle] > array[end]) {
            return minNumberInRotateArray(array, middle + 1, end);
        } else {
            return array[start];
        }
    }


}
