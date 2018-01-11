package cn.njupt.jdk8;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by sunfei on 2018/1/9.
 */
public interface BufferedReaderProcessor {
    String process(BufferedReader br) throws IOException;
}
