//希尔排序也是插入排序的一种,也叫缩小增量排序算法(由于插入排序需要和前面的每个元素比较大小插入,如果相距太远则会浪费运算的时间)
//数组a[n],每次n/2个间隔取出数据进行插入排序(冒泡排序也可以,但是慢),下次间隔n/4进行相同的操作,直到间隔为0为止
//这个算法原理懂但是代码看不懂
package com.shh;
import java.util.Arrays;
public class Day9希尔排序 {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,9,6};
        shellSort(arr); //交换式(冒泡排序)
        //shellSort2(arr);//移位方式(插入排序)
        System.out.println(Arrays.toString(arr));
    }

    // 希尔排序时,对有序序列在插入时采用交换法(冒泡排序)
    public static void shellSort(int[] arr) {
        int temp = 0;
        //10组为例
        //第一次分为5组,每组2个,间隔为5,{a[0],a[5]};{a[1],a[6]};{a[2],a[7]};{a[3],a[8]};{a[4],a[9]}
        //第二次分为2组,每组5个，间隔为2
        //第三次分为1组,每组10个，间隔为1
        for (int gap = arr.length / 2; gap > 0; gap =gap/2)//这一步是为了分配间隔
        {
            for (int i = gap; i < arr.length; i++)
            {
                for (int j = i - gap; j >= 0; j = j-gap)
                {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    //对交换式的希尔排序进行优化->移位法(插入排序,速度更快)
    public static void shellSort2(int[] arr) {

        // 增量gap, 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }
            }
        }
    }
}
