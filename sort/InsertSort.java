/**
 * @Author : huangtianhui
 * @create 2024/6/8 21:28
 * @description :插入排序  将无序数字往有序数组中插入
 *
 * ### 时间复杂度分析
 *
 * 插入排序（Insertion Sort）的时间复杂度在最优、平均和最差情况下有所不同。详细分析如下：
 *
 * #### 最优时间复杂度（Best-case Time Complexity）
 * 插入排序的最优时间复杂度是 O(n)。这种情况发生在输入数组已经有序时，只需要进行 n-1 次比较而无需进行元素移动。
 *
 * #### 平均时间复杂度（Average-case Time Complexity）
 * 插入排序的平均时间复杂度是 O(n^2)。在大多数情况下，数组是部分有序或无序的，每次插入操作都需要进行比较和移动元素。
 *
 * #### 最差时间复杂度（Worst-case Time Complexity）
 * 插入排序的最差时间复杂度是 O(n^2)。这种情况发生在输入数组是逆序时，每次插入操作都需要将新元素插入到已经排序部分的最前面，导致大量的比较和移动操作。
 *
 * #### 具体分析
 * 假设数组长度为 n：
 *
 * 1. **第一趟插入**：需要比较 1 次（假设已经在正确位置）。
 * 2. **第二趟插入**：需要比较 2 次。
 * 3. ...
 * 4. **第 i 趟插入**：需要比较 i 次。
 * 5. **最后一趟插入**：需要比较 n-1 次。
 *
 * 总比较次数为：
 * 1 + 2 + ... + (n-1) = n(n-1)/2
 *
 * 当 n 足够大时，n(n-1)/2 近似为 n^2/2，因此时间复杂度为 O(n^2)。
 *
 * ### 总结
 * 插入排序的时间复杂度在最优情况下是 O(n)，而在平均和最差情况下是 O(n^2)。虽然它在处理小规模数据集或部分有序数据集时表现良好，但在处理大规模无序数据集时，其性能较低。
 */
public class InsertSort {

    private static void insertSort(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            //核心：将无序数字往有序数组中插入
            //i从1 开始，第一个默认有序，把需要插入的数先提出来。
            int nowValue = array[i];
            //0-i(不包括i)都是有序的，从i开始倒序比较，如果更小就将当前值先后移一位，再插入
            for (int j = 0; j < i; j++) {
                //倒序，从i-1 比较到0  即i - 1 - j
                if (nowValue < array[i - 1 - j]) {
                    //后移一位
                    array[i - j] = array[i - j - 1];
                    //插入
                    array[i - j - 1] = nowValue;
                }
            }
        }
        ArrayUtil.printArray(array);

    }

    /**
     * while 实现
     *
     * @param array array
     */
    private static void insertSort2(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            //核心：将无序数字往有序数组中插入
            //i从1 开始，第一个默认有序，把需要插入的数先提出来。
            int nowValue = array[i];
            //倒序比较，从i-1 比较到0
            int index = i - 1;
            while (index >= 0 && nowValue < array[index]) {
                //先后移一位
                array[index + 1 ] = array[index];
                //再插入
                array[index] = nowValue;
                index--;
            }
        }
        ArrayUtil.printArray(array);
    }

    public static void main(String[] args) {
        int[] randomArray = ArrayUtil.randomArray(10);
        ArrayUtil.printArray(randomArray);
        insertSort2(randomArray);
    }
}
