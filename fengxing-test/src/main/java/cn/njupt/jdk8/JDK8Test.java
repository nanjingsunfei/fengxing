package cn.njupt.jdk8;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by sunfei on 2018/1/5.
 */
public class JDK8Test {
    public static void main(String[] args) {
        List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6);

        nums.stream().filter(num -> num != null).forEach(e -> System.out.println(e));

        Stream<Long> fibonacci = Stream.generate(new FibonacciSupplier());
        fibonacci.limit(10).forEach(System.out::println);

        nums.stream().filter(num -> {
            if (num == null) {
                return false;
            }
            if (num < 3) {
                return false;
            }
            return true;
        }).limit(2).forEach(e -> print(e));
    }

    private static void print(int e) {
        System.out.println(e);
    }

}
