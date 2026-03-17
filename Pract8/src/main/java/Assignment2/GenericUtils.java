package Assignment2;

import java.util.List;
public class GenericUtils {
    public static <T> T firstOrNull(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.getFirst();
    }
    public static double sum(List<? extends Number> numbers){
        double result = 0.0;
        for (Number n : numbers){
            result += n.doubleValue();
        }
        return result;
    }
    public static void addDefaultIds(List<? super Integer> ids){
        ids.add(1);
        ids.add(2);
        ids.add(3);
    }
}
