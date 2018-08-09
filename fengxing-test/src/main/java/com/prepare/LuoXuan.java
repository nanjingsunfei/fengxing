package com.prepare;

/**
 * Created by sunfei on 2018/7/7.
 */
public class LuoXuan {

    public static void main(String[] args) {
        LuoXuan test = new LuoXuan();
        int a[][] = {{1,2,3},{8,9,4},{7,6,5}};
        int n = a.length;
        test.test(n, a);
    }

    public void test(int n, int[][] a) {
        if (n <= 0) {
            return;
        }
        int k = n >> 1;
        if ((n & 1) == 0) {
            k = k - 1;
        }

        for (int i = 0; i <= k; i++) {
            if (i == n - i - 1) {
                System.out.println(a[i][i]);
            }
            for (int j = i; j < n - i - 1; j++) {
                System.out.println(a[i][j]);
            }

            for (int j = i; j < n - i - 1; j++) {
                System.out.println(a[j][n - i - 1]);
            }

            for (int j = n - i - 1; j > i; j--) {
                System.out.println(a[n - i - 1][j]);
            }

            for (int j = n - i - 1; j > i; j--) {
                System.out.println(a[j][i]);
            }
        }
    }
}
