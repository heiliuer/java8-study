package study._002lambda_expressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by hao.wang on 2017/2/15.
 */
public class Test {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("name", "birth", "job");
        Collections.sort(names, (name1, name2) -> name1.length() - name2.length());
//        Collections.sort(names, Comparator.comparingInt(String::length));//优化后同上

    }
}
