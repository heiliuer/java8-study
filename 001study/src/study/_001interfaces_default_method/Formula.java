package study._001interfaces_default_method;

/**
 * Created by hao.wang on 2017/2/15.
 */
public interface Formula {

    double calulate(int a);

    // 可以再接口定义中实现部分方法
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
