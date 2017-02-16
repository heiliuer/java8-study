package study._004method_constructor_references;

import study._003functional_interfaces.Converter;

/**
 * Created by Administrator on 2017/2/16 0016.
 */
public class Test {

    public static void main(String[] args) {
        Converter<String, Integer> integerConverter = Integer::valueOf;
        System.out.println(integerConverter.convert("200"));
        // java8 使用::符号来引用方法实例，方法引用可以替代lambda语句（充当其方法体）
        // Java 8 enables you to pass references of methods or constructors via the :: keyword.
        // The above example shows how to reference a static method. But we can also reference object methods:


        PersonFactory factory = Person::new;
        System.out.println(factory.create("hei", "liuer"));
//        Instead of implementing the factory manually,
// we glue everything together via constructor references:
    }
}
