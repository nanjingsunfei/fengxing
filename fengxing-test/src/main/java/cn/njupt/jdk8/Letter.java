package cn.njupt.jdk8;

/**
 * Created by sunfei on 2018/1/13.
 */
public class Letter {
    public static String addHeader(String text) {
        return "From Raoul, Marion and Alan: " + text;
    }

    public static String addFooter(String text) {
        return text + " Kind regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("ladba", "lamdba");
    }
}
