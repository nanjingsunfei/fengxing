package cn.njupt.guava;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by sunfei on 2017/12/28.
 */
public class GuavaTest {

    public static void main(String[] args) {
//        testFunction();
//        testOptional();
//        testObjects();
        testOrdering();

    }

    public static void testFunction() {
        Zebra z1 = new Zebra(1, "1号", 12, "");
        Zebra z2 = new Zebra(2, "", 12, "");
        Zebra z3 = new Zebra(3, "3号", 12, "");
        Zebra z4 = new Zebra(4, "4号", 12, "");

        List<Zebra> zebras = Lists.newArrayListWithCapacity(4);
        zebras.add(z1);
        zebras.add(z2);
        zebras.add(z3);
        zebras.add(z4);

        Function<Zebra, String> function = new Function<Zebra, String>() {
            public String apply(Zebra input) {
                if (StringUtils.isNotBlank(input.getName())) {
                    return input.getId() + "_" + input.getName();
                } else {
                    return null;
                }

            }
        };

        List<String> ids = Lists.transform(zebras, function);

        System.out.println(JSONObject.toJSONString(ids));
    }

    public static void testOptional() {
        Zebra zebra = new Zebra(1, "1号", 12, "");
        Optional<Zebra> optional = Optional.fromNullable(zebra);
        boolean bool = optional.isPresent();
        Zebra z = optional.get();
        System.out.println(z);
        try {
            Zebra zebra1 = zebra;
            checkNotNull(zebra1, "zebra不能为空");
            Object obj = null;
            checkNotNull(obj, "obj为空");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        zebra = null;
        optional = Optional.fromNullable(zebra);
        bool = optional.isPresent();
        z = optional.or(new Zebra(2, "2号", 12, ""));
        System.out.println(z);
    }

    public static void testObjects() {
        Zebra z1 = new Zebra(1, "1号", 12, "");
        Zebra z2 = new Zebra(2, "", 18, "");
        Zebra z3 = new Zebra(3, "3号", 2, "");
        Zebra z4 = new Zebra(4, "4号", 19, "");

        List<Zebra> zebras = Lists.newArrayListWithCapacity(4);
        zebras.add(z1);
        zebras.add(z2);
        zebras.add(z3);
        zebras.add(z4);

        Collections.sort(zebras, Collections.<Zebra>reverseOrder());
        System.out.println(zebras);
    }

    public static void testOrdering() {
        Zebra z1 = new Zebra(1, "1号", 12, "");
        Zebra z2 = new Zebra(2, "", 18, "");
        Zebra z3 = new Zebra(3, "3号", 2, "");
        Zebra z4 = new Zebra(4, "4号", 19, "");

        List<Zebra> zebras = Lists.newArrayList(z1, z2, z3, z4);

        Ordering<Zebra> ordering = new Ordering<Zebra>() {
            @Override
            public int compare(@Nullable Zebra left, @Nullable Zebra right) {
                return ComparisonChain.start().compare(left.getAge(), right.getAge()).result();
            }
        };
        Ordering<Zebra> ordering1 = Ordering.natural().reverse().nullsLast().onResultOf(new Function<Zebra, Integer>() {
            @Nullable
            public Integer apply(@Nullable Zebra input) {
                return input.getAge();
            }
        });

        Collections.sort(zebras, ordering);
        System.out.println(zebras);
        Ordering.natural();
    }
}
