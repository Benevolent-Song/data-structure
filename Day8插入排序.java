//插入排序,将一个数组分成两部分,前部为有序部分,后部为无序部分,每次从无序部分首部
//取出一个元素插入到有序部分中在插入前先保存该元素的下标和数值信息,将取出的元素与
//其前一个个有序部分的元素比较大小,直到比该元素大,则找到的有序元素及其后部整体后移,再将无序插入到该元素前
//动图：https://blog.csdn.net/weixin_45969711/article/details/127741051

package com.shh;
import java.util.Arrays;

public class Day8插入排序 {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,0,-1};
        insertSort(arr);
    }
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++)
        {
            // 待插入的数a[i]
            int insertVal = arr[i];//保存arr[i]的值,防止后续后移时被覆盖了
            int insertIndex = i - 1;// 即要插入的arr[i]前面这个数的下标

            // 给insertVal找到插入的位置
            // 1. insertIndex >= 0 保证在给 insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. arr[insertIndex + 1] = arr[insertIndex]将数组后移
            // 当退出 while 循环时，说明插入的位置找到, insertIndex + 1
            while (insertIndex >= 0 && insertVal < arr[insertIndex])
            {
                arr[insertIndex + 1] = arr[insertIndex]; //将数组整体往后移动
                insertIndex--;//继续前移寻找
            }

            // 这里我们判断是否需要赋值,insertIndex + 1 = i说明无序元素不需要插入操作，所在位置(原无序部分首部)已经构成了有序数组
            if (insertIndex + 1 != i)
            {
                arr[insertIndex + 1] = insertVal;//插入a[i]=insertVal的值
            }
            System.out.println("第" + i + "轮插入");
            System.out.println(Arrays.toString(arr));
        }
    }
}
