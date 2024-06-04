import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author : huangtianhui
 * @create 2024/6/5 00:24
 * @description :
 */
public class BubbleSort {

    /**
     * 简单版
     * @param array 数组
     */
    private static void bubbleSort(int[] array) {

        //外循环，由于循环到array.length-1次时，内循环已经结束。所以不需要循环array.length次
        for (int i = 0; i < array.length-1; i++) {
            //array.length - 1 - i表示第array.length - 1 - i之后的元素顺序已经正确，无需再比较。
            for (int j = 0; j < array.length - 1 - i; j++) {
                printArray(array);
                printMark(j);
                if (array[j] > array[j + 1]) {
                    System.out.print("    "+array[j] + "========>>" + array[j + 1]);
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
                System.out.println("    i=" + i + ",j=" + j + "    ");
            }
            System.out.println("--------------------------------------");
        }
        printArray(array);
    }

    /**
     * 进阶版 提前终止思想，即内循环发现没有数据交换的时候，说明已经上顺序的了，可以提前跳出循环。
     * @param array 数组
     */
    private static void bubbleSort2(int[] array) {

        //外循环，由于循环到array.length-1次时，内循环已经结束。所以不需要循环array.length次
        for (int i = 0; i < array.length-1; i++) {
            boolean swapped = false;
            //array.length - 1 - i表示第array.length - 1 - i之后的元素顺序已经正确，无需再比较。
            for (int j = 0; j < array.length - 1 - i; j++) {
                printArray(array);
                printMark(j);
                if (array[j] > array[j + 1]) {
                    System.out.print("    "+array[j] + "========>>" + array[j + 1]);
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swapped = true;
                }
                System.out.println("    i=" + i + ",j=" + j + "    ");
            }
            if (!swapped){
                break;
            }
            System.out.println("--------------------------------------");
        }
        printArray(array);
    }
    private static void printArray(int[] array) {
        System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    private static void printMark(int j) {
        for (int i = 0; i < j; i++) {
            System.out.print("   ");
        }
        System.out.print("△");
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] randomArray = IntStream.generate(() -> random.nextInt(100))
                .limit(10)
                .toArray();

        printArray(randomArray);
        System.out.println("begin--------------------------------------");

        //bubbleSort(randomArray);
        bubbleSort2(randomArray);
    }
}
