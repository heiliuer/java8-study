package study._003functional_interfaces;

/**
 * Created by hao.wang on 2017/2/15.
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
