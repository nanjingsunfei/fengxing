package cn.njupt.enumTest;

/**
 * Created by sunfei on 2018/3/18.
 */
public enum Person {
    MAN("男", 0),
    WOMAN("女", 1);

    public final String name;

    public final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static Person getPersonByName(String name) {
        for (Person person : values()) {
            if (person.name == name) {
                return person;
            }
        }
        return null;
    }


}
