//选择排序,从a[0]开始往后找到最小值,找到后最小值与a[0]交换位置,再a[1]重复这样的操作
package com.shh;

import java.util.Arrays;

public class Day8选择排序 {
    public static void main(String[] args) {
        int [] list={5,4,3,1,2};
        sort(list);
    }
    public static void sort(int[] array)
    {
        int min=0;
        int index=0;
        int mm;//交换值时用于暂存中间变量值
        for(int i=0;i<array.length-1;i++)
        {
            min=array[i];
            index=i;
            for(int j=i;j<array.length;j++)//在a[j]~a[array.length-1]中找到最小值,最后赋值给a[i]
            {
              if (array[j]<min)
              {
                  index=j;//取最小值的下标
                  min=array[j];//最小值记录被改变了
              }
            }
            mm=array[i];//这三段是将两个数组元素的值交换,将最小值的数组元素与a[i]交换
            array[i]=array[index];
            array[index]=mm;
        }
        System.out.print(Arrays.toString(array));//将最后的交换结果给打印出来(将数组转化为字符串)
    }
}
