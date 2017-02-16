package study._003functional_interfaces;

/**
 * Created by hao.wang on 2017/2/15.
 */
public class Test {

    public static void main(String[] args) {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        System.out.println(converter.convert("222"));

    }
}
