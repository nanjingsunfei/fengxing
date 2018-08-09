package com.prepare;

/**
 * Created by sunfei on 2018/7/11.
 */
public class Main13 {
    public static void main(String[] args) {
        Main13 main13 = new Main13();
        int[] a = {1, 4, 2, 2, 4, 1, 5};
        System.out.println(main13.getXushui(a));
    }

    public int getXushui(int[] a) {
        int length = a.length;
        int[] b = new int[length];
        for (int i = 0; i < length; i++) {
            b[i] = a[i];
        }
        int first = 0;
        while (true) {
            first = getFirst(first, b);
            if (first == length) {
                break;
            }
            int next = getFirst(first + 1, b);
            if (next == length) {
                break;
            }
            int min = Math.min(b[first], b[next]);
            for (int j = first + 1; j < next; j++) {
                if (b[j] < min) {
                    b[j] = min;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += b[i] - a[i];
        }
        return sum;
    }

    public int getFirst(int first, int[] b) {
        for (int i = first + 1; i < b.length; i++) {
            if (b[i] < b[i - 1]) {
                return i - 1;
            }
        }
        return b.length-1;
    }

//    public int getNext(int index, int[] b) {
//        for (int i = index; i < b.length; i++) {
//            if (b[i] > b[i-1]) {
//                return i;
//            }
//        }
//        return -1;
//    }

}
