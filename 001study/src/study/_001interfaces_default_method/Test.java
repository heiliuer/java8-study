package study._001interfaces_default_method;

/**
 * Created by hao.wang on 2017/2/15.
 */
public class Test {

    public static void main(String[] args) {
        Formula formula = new Formula() {

            @Override
            public double calulate(int a) {
//                or sqrt(a) 调用接口已经实现的方法
                return this.sqrt(a);
            }
        };

        System.out.println(formula.calulate(20));
        System.out.println(formula.sqrt(300));
    }
}
