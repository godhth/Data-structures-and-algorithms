/**
 * @Author : huangtianhui
 * @create 2024/6/8 22:50
 * @description : 快速排序
 * 先取基准数，将数组分区，再对左右两侧进行递归
 * 如：
 * [1, 0, 2] 3 [7, 4, 6]
 * <p>
 * 核心：引入分区指示器，最终即上述3所在的位置
 * 可取最后一位数为基准，遍历所有数字，当前数字 <= 基准数   则当前数字和分区指示器后一位交换，分区指示器到当前数字索引
 * 分区指示器从 -1开始
 * 1<3 分区指示器指向1
 * [1, 7, 0, 4, 2, 6, 3]
 * <p>
 * 0<3  0和7交换 分区指示器指向0
 * [1, 0, 7, 4, 2, 6, 3]
 * <p>
 * <p>
 * 快速排序的时间复杂度分析：
 * <p>
 * 平均情况下，快速排序的时间复杂度为 O(n log n)。这是因为每次分区操作都将数组分成两部分，并且每部分的大小大致相等。分区的时间复杂度为 O(n)，其中 n 是数组的大小，因为需要线性时间来遍历数组并移动元素。而递归调用的次数大约为 log n，因此总体时间复杂度为 O(n log n)。
 * <p>
 * 最坏情况下，快速排序的时间复杂度为 O(n^2)。最坏情况发生在每次分区都只能将数组分成一个元素和其他元素两部分，这可能在数组已经是有序的或近乎有序的情况下发生。在这种情况下，每次分区的时间复杂度为 O(n)，并且需要递归调用的次数为 O(n)，因此总体时间复杂度为 O(n^2)。
 * <p>
 * 最优情况下，快速排序的时间复杂度也是 O(n log n)。最优情况发生在每次分区都能将数组均匀地分成两部分，这可以通过选择合适的分区点（通常是中间元素）来实现。在这种情况下，每次分区的时间复杂度为 O(n)，并且递归调用的次数为 log n，因此总体时间复杂度为 O(n log n)。
 * <p>
 * 综上所述，快速排序在平均情况下表现良好，具有 O(n log n) 的时间复杂度。然而，在最坏情况下，它可能退化为 O(n^2)，但这种情况的概率相对较低。因此，在实践中，快速排序通常是一个高效的排序算法。
 */
public class QuickSort {

    public static void quickSort(int[] array, int begin, int end) {
        int length = end - begin + 1;
        if (length <= 1) {
            return;
        }
        //基准数
        int baseNum = array[end];
        //分区指示器，左边就是比基准数小的，右边就是比基准数大
        int partitionIndex = -1 + begin;
        for (int i = 0; i < length; i++) {
            //当前数字索引，全部加上begin是因为 方便递归，针对一个数组偏移begin个
            int nowIndex = begin + i;
            if (array[nowIndex] <= baseNum) {
                //右边的数即(分区指示器+1)  和当前比基准数小的数交换
                //交换
                int tmp = array[nowIndex];
                array[nowIndex] = array[partitionIndex + 1];
                array[partitionIndex + 1] = tmp;
                //分区指示器右移
                partitionIndex++;
            }
        }
        //分区左边递归排序
        quickSort(array, begin, partitionIndex - 1);
        //分区右边递归排序
        quickSort(array, partitionIndex + 1, end);

    }

    public static void main(String[] args) {
        int[] randomArray = ArrayUtil.randomArray(10);
        ArrayUtil.printArray(randomArray);
        quickSort(randomArray, 0, 9);
        ArrayUtil.printArray(randomArray);
    }
}
