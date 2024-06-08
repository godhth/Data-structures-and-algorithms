/**
 * @Author : huangtianhui
 * @create 2024/6/8 20:54
 * @description : 选择排序
 * #### 具体分析
 * 假设数组长度为 n：
 * <p>
 * 1. **第一趟排序**：需要比较 n-1 次。
 * 2. **第二趟排序**：需要比较 n-2 次。
 * 3. ...
 * 4. **第 i 趟排序**：需要比较 n-i 次。
 * 5. **最后一趟排序**：需要比较 1 次。
 * <p>
 * 总比较次数为：
 * (n-1) + (n-2) + ... + 1 = n(n-1)/2
 * <p>
 * 当 n 足够大时，n(n-1)/2 近似为 n^2/2，因此时间复杂度为 O(n^2)。
 * <p>
 * ### 总结
 * 选择排序的时间复杂度无论在最优、平均还是最差情况下，都是 O(n^2)，而空间复杂度是 O(1)。虽然它的时间复杂度较高，但由于实现简单且不需要额外的内存，因此在一些小规模数据集上仍然是一个可行的选择。
 * <p>
 * 最优时间复杂度
 * 选择排序的最优时间复杂度是
 * 𝑂(𝑛2)不管输入数组是否已经排序，选择排序总是需要进行比较来找到未排序部分的最小（或最大）元素。
 * 平均时间复杂度
 * 选择排序的平均时间复杂度也是
 * 𝑂(𝑛2)在排序过程中，每次都需要在未排序部分找到最小（或最大）的元素，导致在每次迭代中进行大量的比较操作。
 * 最差时间复杂度
 * 选择排序的最差时间复杂度同样是
 * 𝑂(𝑛2)。即使数组是完全逆序的，选择排序的比较次数不会改变，因为每次都需要遍历未排序部分找到最小（或最大）元素。
 */
public class ChooseSort {

    private static void chooseSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            //核心：每次找到剩余数字的最小（大）值，与当前位置交换
            int minIndex = i;
            // 遍历从 i+1 到 n 的元素，找到最小元素的索引
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 将最小元素和当前元素 i 交换
            if (minIndex != i) {
                int min = array[minIndex];
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
        ArrayUtil.printArray(array);
    }

    public static void main(String[] args) {
        int[] randomArray = ArrayUtil.randomArray(10);
        ArrayUtil.printArray(randomArray);
        chooseSort(randomArray);
    }
}
