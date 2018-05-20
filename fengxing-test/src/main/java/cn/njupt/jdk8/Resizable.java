package cn.njupt.jdk8;

/**
 * Created by sunfei on 2018/1/25.
 */
public interface Resizable {
    int getWidth();
    int getHeight();
    void setWidth(int width);
    void setHeight(int height);
    void setAbsoluteSize(int width, int height);
    default void setRelativeSize(int wFactor, int hFactor) {

    }
}
