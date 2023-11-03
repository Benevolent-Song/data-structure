//和二分查找类似,但是其确定mid的方式和二分查找不同
//mid=left + (right – left) * (findVal – arr[left]) / (arr[right] – arr[left])
//还有查找中没有找到结果的判断增加了goal < array[0] || goal > array[array.length - 1]
//对于二分插值和插值查找的选择,对于均匀分布使用二分查找比较快,对于数组数值分布相差大的使用插值查找比较快

package com.shh;
public class Day10插值查找 {
    public static void main(String[] args) {
        int [] list={1,2,3,4,5,6,7};
        int indexvalue=search1(list,0,list.length - 1,5);
        System.out.println(indexvalue);
    }
    public static int search1(int [] array,int left,int right,int goal)
    {
        int mid=left+(right-left)*(goal-array[left])/(array[right]-array[left]);
        int midvalue=array[mid];
        if(left>right || goal < array[0] || goal > array[array.length - 1])//查找完后仍然没有找到结果
        {
            return -1;
        }
        if(goal>midvalue)//向右递归
        {
            return search1(array,mid+1,right,goal);
        }
        else if(goal<midvalue)//向左递归
        {
            return search1(array,left,mid-1,goal);
        }
        else//此时goal=mid,得到了结果
        {
            return mid;
        }
    }
}
