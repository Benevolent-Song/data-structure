//两两比较大小,一次比较将最大值冒泡到最后
//每一次冒泡后下一次比较的次数减少一次,因为最大值已经在后面了,只要将剩下中的最大值冒泡到后处就可以了
//不一定要比较完,可以设置标志位flag,只要有一次冒泡没有改变顺序,说明已经是顺序了,直接结束冒泡程序。
package com.shh;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Day8冒泡排序 {
    public static void main(String[] args) {
      int [] list={1,2,6,5,4};
      sort(list);
    }
    public static void sort(int[] array)
    {
        boolean flag=false;
        int m;//交换值时暂放数据的中间变量
        for(int i=0;i<array.length-1;i++)//进行n次冒泡,有标志位flag,如果已经顺序了则提前结束排序
        {
            for(int j=0;j<array.length-i-1;j++)//对数列的前length-i-1个中最大值冒泡到底部,之前最大值次大值都已经沉底了
            {
                if(array[j]>array[j+1])
                {
                    flag=true;
                    m=array[j+1];
                    array[j+1]=array[j];
                    array[j]=m;
                }
            }
            //System.out.println("第" + (i + 1) + "趟排序后的数组");
            //System.out.println(Arrays.toString(array));
            if(!flag)//说明此次排序没有位次的改变,已经是顺序结构了,此时退出程序
            {
                System.out.println(Arrays.toString(array));
                return;
            }
            else
            {
                flag=false;
            }
        }
    }
}
