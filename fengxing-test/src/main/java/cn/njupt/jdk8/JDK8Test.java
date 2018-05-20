package cn.njupt.jdk8;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.apache.zookeeper.Op;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

/**
 * Created by sunfei on 2018/1/5.
 */
public class JDK8Test {
    public static void main(String[] args) {
        JDK8Test test = new JDK8Test();
        test.testOptional();
//        test.testStream();
//        test.testStream2();
//        test.testStream3();
        test.testStream4();

        System.out.println("-------------");
        System.out.println();

        List<String> list = Lists.newArrayList("122", "10", "2034");
        list.sort(Comparator.comparing(Integer::parseInt));

        list.sort(String::compareToIgnoreCase);

        list.stream().forEach(System.out::println);

        test.testConsumer(list, a -> System.out.println(a));

        boolean bool = test.testPredicate(list, a -> "a".equals(a));
        System.out.println(bool);

        List<String> strList = test.testFunction(list, (String a) -> a + a);
        System.out.println(JSONObject.toJSONString(strList));

        String result = test.testBinaryOperator("aaa", "bbb", (a, b) -> a + b);
        System.out.println(result);

        boolean bool2 = test.testBiFunction("aaa", 1, (a, b) -> {
            if (a.equals("aaa") && b == 1) {
                return true;
            }
            return false;
        });
        System.out.println(bool2);

        Supplier<Apple> c1 = Apple::new;
        Apple apple = c1.get();

        Supplier<Apple> c2 = () -> new Apple();
        apple = c2.get();

        Function<String, Apple> function = Apple::new;
        Apple a2 = function.apply("red apple!");

        BiFunction<Integer, String, Apple> biFunction = Apple::new;
        Apple a3 = biFunction.apply(1, "red");

        List<Apple> apples = test.map(list, Apple::new);
        apples.stream().forEach(System.out::println);

        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationpipeline = addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);
        System.out.println(transformationpipeline.apply("ladba"));

        apples.stream().map(Apple::getName).collect(Collectors.toList());

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
    }

    private List<Apple> map(List<String> names, BiFunction<Integer, String, Apple> biFunction) {
        List<Apple> apples = new ArrayList<>();

        names.stream().forEach(name -> {
            apples.add(biFunction.apply(1, name));
        });
        return apples;
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

    private void print(Zebra z) {
        z.print();
    }

    private void process(Runnable r) {
        r.run();
    }

    private String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))
        ) {
            return p.process(br);
        }
    }

    private <T> void testConsumer(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    private <T> boolean testPredicate(List<T> list, Predicate<T> predicate) {
        for (T t : list) {
            return predicate.test(t);
        }
        return false;
    }

    private <T> List<T> testFunction(List<T> list, Function<T, T> function) {
        List<T> newList = Lists.newArrayList();
        for (T t : list) {
            T tt = function.apply(t);
            newList.add(tt);
        }
        return newList;
    }

    private <T> T testBinaryOperator(T t1, T t2, BinaryOperator<T> binaryOperator) {
        return binaryOperator.apply(t1, t2);
    }

    private <T, U, R> R testBiFunction(T t, U u, BiFunction<T, U, R> biFunction) {
        return biFunction.apply(t, u);
    }

    private void testStream() {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        List<String> threeHighCaloricDishNames = menu.stream().filter(a -> a.getCalories() > 30).map(a -> a.getName()).limit(3).collect(Collectors.toList());
        System.out.println(threeHighCaloricDishNames);

        List<String> strList = menu.stream().map(Dish::getName).map(s -> s.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(strList);

        boolean bool = menu.stream().anyMatch(a -> a.getName().equals("pizza"));
        System.out.println(bool);
        bool = menu.stream().allMatch(Dish::isVegetarian);
        System.out.println(bool);
        bool = menu.stream().noneMatch(a -> a.getName().equals("pizza"));
        System.out.println(bool);

        System.out.println("--------------find any------------------");
        Optional<Dish> dish = menu.stream().filter(a -> a.getCalories() > 500).findAny();
        if (dish.isPresent()) {
            System.out.println(dish.get());
        } else {
            System.out.println("none");
        }
        dish.ifPresent(System.out::println);

        dish = menu.stream().filter(a -> a.getCalories() > 800).findAny();
        if (dish.isPresent()) {
            System.out.println(dish.get());
        } else {
            System.out.println("none");
        }
        System.out.println("--------------find any------------------");

        System.out.println("--------------find first------------------");
        dish = menu.stream().filter(a -> a.getCalories() > 800).findFirst();
        System.out.println(dish.orElse(new Dish("lufei", false, 10, Dish.Type.FISH)));
        System.out.println("--------------find first------------------");

        System.out.println("--------------reduce------------------");
        int sum = menu.stream().map(Dish::getCalories).reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        Optional<Integer> sumOptional = menu.stream().map(Dish::getCalories).reduce((a, b) -> a + b);
        sumOptional.ifPresent(System.out::println);


        int max = menu.stream().map(Dish::getCalories).reduce(0, Integer::max);
        System.out.println(max);
        System.out.println("--------------reduce------------------");
    }

    private void testStream2() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        transactions.stream().filter(a -> a.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).forEach(System.out::println);
        transactions.stream().map(t -> t.getTrader().getCity()).distinct().forEach(System.out::println);
        transactions.stream().map(Transaction::getTrader).filter(a -> a.getCity().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName)).forEach(System.out::println);

        String str = transactions.stream().map(a -> a.getTrader().getName()).distinct().sorted().reduce("", (a, b) -> a + b);
        System.out.println(str);

        Optional<Trader> optional = transactions.stream().map(Transaction::getTrader).filter(a -> "milan".equals(a.getCity())).findAny();
        optional.ifPresent(System.out::println);

        transactions.stream().filter(a -> a.getTrader().getName().equals("Cambridge")).forEach(a -> System.out.println(a.getValue()));

        int max = transactions.stream().map(Transaction::getValue).reduce(0, Integer::max);
        System.out.println(max);

        Optional<Transaction> minOptional = transactions.stream().reduce((a, b) -> a.getValue() > b.getValue() ? b : a);
        minOptional.ifPresent(System.out::println);

        transactions.stream().min(Comparator.comparing(Transaction::getValue));

        IntStream intStream = transactions.stream().mapToInt(Transaction::getValue);
        intStream.sum();
        intStream.max();
    }

    private void testStream3() {
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();

        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();

            lines.map(line -> line.split("")).flatMap(Arrays::stream) .distinct().count();
        } catch (IOException e) {
        }

        Stream.iterate(new int[]{0, 1}, t -> new int[] {t[1], t[0] + t[1]}).limit(20).map(t -> t[0]).forEach(System.out::println);

    }

    private void testStream4() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        Map<Integer, List<Transaction>> map = transactions.stream().collect(Collectors.groupingBy(Transaction::getYear));

        Map<Trader, Integer> map2 = transactions.stream().collect(Collectors.toMap(Transaction::getTrader, Transaction::getValue, (k1, k2) -> k1));

        Optional<Transaction> optional = transactions.stream().collect(Collectors.maxBy(Comparator.comparing(Transaction::getValue)));

        String joiningStr = transactions.stream().map(t -> t.getTrader().getName()).collect(Collectors.joining(", "));
        System.out.println(joiningStr);

        int sum = transactions.stream().collect(Collectors.reducing(0, (Transaction e) -> e.getValue(), (s1, s2) -> s1 + s2));
        System.out.println(sum);

        String join1 = transactions.stream().map(t -> t.getTrader().getName()).collect(Collectors.joining());
        String join2 = transactions.stream().map(t -> t.getTrader().getName()).collect(Collectors.reducing((s1, s2) -> s1 + s2)).orElse("");
        System.out.println(join1);
        System.out.println(join2);

        Map<Integer, Transaction> mostCaloricByType =
                transactions.stream()
                        .collect(groupingBy(Transaction::getYear, collectingAndThen(maxBy(comparingInt(Transaction::getValue)),
                                        Optional::get)));

        Map<Integer, List<Integer>> map1 = transactions.stream()
                        .collect(groupingBy(Transaction::getYear, collectingAndThen(toList(), list -> list.stream().map(Transaction::getValue).collect(Collectors.toList()))));

        System.out.println(JSONObject.toJSONString(map1));

        Map<Integer, List<Integer>> map3 = transactions.stream()
                .collect(groupingBy(Transaction::getYear, mapping(Transaction::getValue, toCollection(ArrayList::new))));

        System.out.println(JSONObject.toJSONString(map3));

        System.out.println(transactions);
        List<Transaction> transactions1 = transactions.stream().collect(new ToListCollector<Transaction>());
        System.out.println(transactions1);


        UnaryOperator<String> headerProcessing =
                (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing =
                (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline =
                headerProcessing.andThen(spellCheckerProcessing);
        String result = pipeline.apply("Aren't labdas really sexy?!!");

    }

    private void testOptional() {
        Optional<Apple> optApple = Optional.empty();
        if (!optApple.isPresent()) {
            System.out.println("none");
        }
        Optional<Apple> optApple1 = Optional.of(new Apple("red"));
        optApple1.ifPresent(apple -> System.out.println(apple.getName()));

        Optional<Apple> optApple2 = Optional.ofNullable(null);

        Optional<Apple> optApp3 = Optional.of(new Apple("123"));
        Optional<Integer> optInt = optApp3.map(Apple::getName).map(str -> Integer.valueOf(str));
        optInt.ifPresent(System.out::println);

        int value = optInt.orElseGet(() -> 1);
        System.out.println(value);
    }
}
