package cn.njupt.jdk8;

import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sunfei on 2018/1/5.
 */
public class JDK8Test {
    public static void main(String[] args) {
        JDK8Test test = new JDK8Test();
        test.lambdaSupport();
    }

    private void lambdaSupport() {
        List<Integer> list = Lists.newArrayList(1, 2, 3);

        list.forEach(e -> System.out.println(e));

        list.forEach(e -> {
            System.out.println(e);
        });

        List<Integer> newList = filter(list, a -> a >= 2);
        newList.forEach(e -> System.out.println(e));


        process(() -> System.out.println("This id awesome"));
        print(() -> System.out.println("This id awesome"));

        try {
            processFile((BufferedReader br) -> br.readLine() + br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                newList.add(t);
            }
        }
        return newList;
    }

    private void process(Runnable r) {
        r.run();
    }

    private void print(Zebra z) {
        z.print();
    }

    private String processFile(BufferedReaderProcessor p) throws IOException{
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))
        ) {
            return p.process(br);
        }
    }
}
