package cn.njupt.guava;

/**
 * Created by sunfei on 2018/1/7.
 */
public class Main {
    public static void main(String[] args) {

        Test test = new Test() {
            @Override
            public void test(int a, int b) {
                System.out.println(a + b);
            }
        };

        test.test(1, 2);

    }
}