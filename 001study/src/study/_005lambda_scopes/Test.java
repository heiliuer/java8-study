package study._005lambda_scopes;

import study._003functional_interfaces.Converter;

/**
 * Created by Administrator on 2017/2/16 0016.
 */
public class Test {


    // Accessing outer scope variables from lambda expressions is very similar to anonymous objects.
    // You can access final variables from the local outer scope as well as instance fields and static variables.
    public static void main(String[] args) {

        accessing_local_variables();
        accessing_fields_and_static_variables();

    }

    private static void accessing_fields_and_static_variables() {
    }

    private static void accessing_local_variables() {
        int times = 10;
        Converter<Float, String> converter = from -> Float.toString(from * times);
        //times = 20;//times 不能被修改 否则报错
        //Error:(12, 76) java: 从lambda 表达式引用的本地变量必须是最终变量或实际上的最终变量
        System.out.println(converter.convert(20F));

        int plus = 20;
        converter = from -> Float.toString(from + plus);
        System.out.println(converter.convert(20F));
        //OK

        final int minus = 20;
        converter = from -> Float.toString(from - minus);
        System.out.println(converter.convert(20F));
        //OK
    }
}
