package cn.njupt.jdk8;

/**
 * Created by sunfei on 2018/1/24.
 */
public class Validator {
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s){
        return strategy.execute(s);
    }

    public static void main(String[] args) {
        Validator validator = new Validator((String s) -> s.matches("[a-z]+"));
        boolean bool = validator.validate("str");
        System.out.println(bool);
    }


}
