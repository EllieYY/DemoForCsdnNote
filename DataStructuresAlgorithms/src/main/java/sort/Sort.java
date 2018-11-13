package sort;

import generators.Generated;
import generators.Generator;
import generators.PrimitiveGenerator;
import stackDemo.LinkedListStack;
import stackDemo.ObjectArrayStack;

import javax.sound.midi.Soundbank;
import java.lang.reflect.ParameterizedType;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.Random;

/**
 * @Description : TODO
 * @Author : Ellie
 * @Date : 2018/11/12
 */
public class Sort {
    public static <T extends Comparable<T>> void BubbleSort(T[] values, int length) {
        if (length <= 1)
            return;

        int flag = length;
        while (flag > 0) {
            int end = flag - 1;
            flag = 0;

            for (int j = 0; j < end; j++) {
                if (values[j].compareTo(values[j+1]) > 0) {
                    T tmp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = tmp;

                    flag = j + 1;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void InsSort(T[] values, int length) {
        if (length <= 1)
            return;

        for (int i = 0; i < length; i++) {
            T v = values[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (values[j].compareTo(v) > 0) {
                    values[j+1] = values[j];
                } else {
                    break;
                }
            }

            values[j+1] = v;
        }
    }


    public static <T extends Comparable<T>> void SelSort(T[] values, int length) {
        if (length <= 1)
            return;

        for (int i = 0; i < length; i++) {
            T min = values[i];

            int minIdx = i;
            for (int j = i + 1; j < length; j++) {
                if (values[j].compareTo(min) < 0) {
                    min = values[j];
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                T tmp = values[i];
                values[i] = values[minIdx];
                values[minIdx] = tmp;
            }
        }
    }

    private static <T extends Comparable<T>> void SortC(T[] values, int left, int right, T[] tmp) {
        if (left >= right)
            return;

        int mid = (left + right)/2;
        for (int i = left; i <= right; i++) {
            if (i == mid + 1)
                System.out.print("     +      ");
            System.out.print(values[i] + " ");
        }
        System.out.println("");

        SortC(values, left, mid, tmp);
        SortC(values, mid + 1, right, tmp);
        MergeC(values, left, mid, right, tmp);
    }
    private static <T extends Comparable<T>> void MergeC(T[] values, int left, int mid, int right, T[] tmp) {
        int i = left;
        int j = mid + 1;
        int tmpIdx = 0;
        while (i <= mid && j <= right) {
            if (values[i].compareTo(values[j]) < 1) {
                tmp[tmpIdx++] = values[i++];
            } else {
                tmp[tmpIdx++] = values[j++];
            }
        }

        while (i <= mid) {
            tmp[tmpIdx++] = values[i++];
        }
        while (j <= right) {
            tmp[tmpIdx++] = values[j++];
        }

        tmpIdx = 0;
        for (i = left; i <= right; i++) {
            values[i] = tmp[tmpIdx++];
        }
    }

    public static <T extends Comparable<T>> void MerSort(Integer[] values, int length, Generator<T> gen) {
        if (length <= 1)
            return;

        Integer[] tmp = new Integer[length];

        System.out.println(Arrays.toString(values));
        SortC(values, 0, length - 1, tmp);
    }

    private static <T extends Comparable<T>> int partition(T[] values, int left, int right) {
        T pivot = values[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (values[j].compareTo(pivot) < 0) {
                T tmp = values[i];
                values[i] = values[j];
                values[j] = tmp;
                i++;
            }
        }

        T tmp = values[right];
        values[right] = values[i];
        values[i] = tmp;

        return i;
    }
    private static int getPivotIdx(int min, int max) {
        Random rand = new Random(47);

        return max;
    }

    private static <T extends Comparable<T>> void QuickSortC(T[] values, int left, int right) {
        if (left >= right)
            return;

//        int partIdx = partition(values, left, right);
//        QuickSortC(values, left, partIdx - 1);
//        QuickSortC(values, partIdx + 1, right);
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        int partIdx = partition(values, left, right);
        if (left < partIdx - 1) {
            stack.push(left);
            stack.push(partIdx);
        }
        if (partIdx + 1 < right) {
            stack.push(partIdx + 1);
            stack.push(right);
        }

        while(!stack.empty()) {
            right = stack.pop();
            left = stack.pop();

            partIdx = partition(values, left, right);

            if (partIdx == left || partIdx == right)
                continue;

            if (left < partIdx - 1) {
                stack.push(left);
                stack.push(partIdx);
            }
            if (partIdx + 1 < right) {
                stack.push(partIdx + 1);
                stack.push(right);
            }
        }
    }
    public static <T extends Comparable<T>> void QuickSort(T[] values, int length) {
        QuickSortC(values, 0, length - 1);
    }

    public static void CountingSort(Integer[] values, int length) {
        if (length <= 1)
            return;
        int max = values[0];
        for (int i = 0; i < length; i++) {
            if (max < values[i]) {
                max = values[i];
            }
        }

        // 构造索引数组并初始化
        int[] c = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            c[i] = 0;
        }

        // 统计
        for (int i = 0; i < length; i++) {
            c[values[i]]++;
        }

        // 累加得到索引值
        for (int i = 1; i <= max; i++) {
            c[i] += c[i-1];
        }

        int r[] = new int[length];
        for (int i = length - 1; i >= 0; --i) {
            int index = c[values[i]] - 1;
            r[index] = values[i];
            c[values[i]]--;
        }

        for (int i = 0; i < length; i++) {
            values[i] = r[i];
        }
    }

    public static void main(String[] args){
        Random rand = new Random(47);
        rand.getClass();
        int length = 8;
        Integer[] values1 = new Integer[length];
        Integer[] values2 = new Integer[length];
        for (int i = 0; i < length; i++) {
            int tmp = rand.nextInt(length);
            values1[i] = tmp;
            values2[i] = tmp;
        }

        System.out.println("sort");
        System.out.println("befor:" + Arrays.toString(values1));
        long begintime = System.currentTimeMillis();
        QuickSort(values1, length);
        long endtime = System.currentTimeMillis();
        System.out.println("after:" + Arrays.toString(values1));
        System.out.println("time: " + (endtime - begintime) + "ms");

    }
}
