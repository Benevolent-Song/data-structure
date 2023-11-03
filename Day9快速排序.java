//快速排序（Quicksort）是对冒泡排序的一种改进。基本思想是：通过一趟排序将要排序的数据分割成独立的两
//部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排
//序，整个排序过程可以递归进行，以此达到整个数据变成有序序列
//https://www.bilibili.com/video/BV1K44y1k79z/?spm_id_from=333.337.search-card.all.click&vd_source=280a3cf02d97d70a35abb153450e5cde
//这个算法还不太熟
package com.shh;
import java.util.Arrays;

public class Day9快速排序 {
    public static void main(String[] args) {
    int [] list={-1,12,0,-3,6,77,9,-12};
    quickSort(list, 0, list.length-1);
    System.out.println(Arrays.toString(list));
    }
    public static void quickSort(int[] arr,int left, int right) {
        int l = left; //左下标
        int r = right; //右下标
        //pivot 中轴值,基准值其实是可以随意取得
        int pivot = arr[(left + right) / 2];
        int temp = 0; //临时变量，作为交换时使用
        //while循环的目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while( l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while( arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while(arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if( l >= r) {
                break;
            }
            //由于arr[r]<pivot,arr[l]>pivot,arr[r]和arr[l]交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值相等 r--， 前移
            if(arr[l] == pivot) {
                r -= 1;
            }

            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if(arr[r] == pivot) {
                l += 1;
            }
        }
        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归,对于第一次进行分组的左半部分再次分组
        if(left < r) {
            quickSort(arr, left, r);
        }
        //向右递归,对于第一次进行分组的左半部分再次分组
        if(right > l) {
            quickSort(arr, l, right);
        }
    }
}
