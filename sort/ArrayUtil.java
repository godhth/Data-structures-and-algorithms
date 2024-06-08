import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author : huangtianhui
 * @create 2024/6/8 20:48
 * @description :
 */
public class ArrayUtil {

    public static void printArray(int[] array) {
        System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    public static int [] randomArray(int size){
        Random random = new Random();
        return IntStream.generate(() -> random.nextInt(100))
                .limit(size)
                .toArray();
    }
}
