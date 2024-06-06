import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author : huangtianhui
 * @create 2024/6/5 00:24
 * @description : 冒泡排序
 * 核心是内循环，比如10个数 只需要对比9次，所以内循环是10-1=9   当完成一次内循环对比后，末尾的数字已经是有序，如10个数，第一次循环需要对比9次，第二个循环只要前面9个数对比，也就是8次。
 * 直到第8次循环，只剩下2个数，对比一次就结束了。所以外循环只需要9次  即10-1
 *
 * 时间复杂度分析
 *
 * 最坏情况时间复杂度：O(n²)
 * 当输入序列是逆序排列时，每次比较都需要交换元素。总共需要进行(n-1) + (n-2) + ... + 1 次比较和交换，故时间复杂度为O(n²)。
 *
 * 平均情况时间复杂度：O(n²)
 * 在平均情况下，元素比较和交换的次数大致和最坏情况一样，时间复杂度也为O(n²)。
 *
 * 最好情况时间复杂度：O(n)
 * 当输入序列已经是有序时，只需进行一趟比较，没有任何交换。每一趟的比较都能发现序列已经有序，所以时间复杂度为O(n)。
 */
public class BubbleSort {

    /**
     * 简单版
     * @param array 数组
     */
    private static void bubbleSort(int[] array) {
        int length = array.length;
        //外循环，由于循环到array.length-1次时，内循环已经结束。所以不需要循环array.length次
        for (int i = 0; i < length-1; i++) {
            //array.length - 1 - i表示第array.length - 1 - i之后的元素顺序已经正确，无需再比较。
            for (int j = 0; j < length - 1 - i; j++) {
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
        int length = array.length;
        //外循环，由于循环到array.length-1次时，内循环已经结束。所以不需要循环array.length次
        for (int i = 0; i < length-1; i++) {
            boolean swapped = false;
            //array.length - 1 - i表示第array.length - 1 - i之后的元素顺序已经正确，无需再比较。
            for (int j = 0; j < length - 1 - i; j++) {
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
