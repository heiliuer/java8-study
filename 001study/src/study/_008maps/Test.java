package study._008maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/16 0016.
 */
public class Test {

    // As already mentioned maps do not directly support streams.
    // There's no stream() method available on the Map interface itself,
    // however you can create specialized streams upon the keys,
    // values or entries of a map via map.keySet().stream(), map.values().stream() and map.entrySet().stream().

    public static void main(String[] args) {
        foreach();
        compute();
        remove();
    }

    private static void compute() {
        Map<Integer, String> map = getMap();

        map.computeIfPresent(3, (num, val) -> val + num);//当存在key=3的val时,替换val值

        map.computeIfAbsent(3, (num) -> "val" + num);//当不存在key=3的val时,替换val值

        map.compute(3, (num, val) -> val + num);//替换key=3的val值

    }

    private static void remove() {
        Map<Integer, String> map = getMap();
        map.remove(3, "val3");
        map.get(3);             // val33

        map.remove(3, "val33");
        map.get(3);             // null

        map.getOrDefault(3, "default");

        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        map.get(9);             // val9concat
    }

    public static Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val_" + i);//当不存在key=i的val或者val==null时put
        }
        return map;
    }

    private static void foreach() {
        getMap().forEach((id, val) -> System.out.println(val));
    }


}
