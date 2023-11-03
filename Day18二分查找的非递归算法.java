//二分查找的序列必须是升序排序好了的
package com.shh;
public class Day18二分查找的非递归算法 {
    public static void main(String[] args) {
        int [] array={1,2,3,4,5,6};
        BinarySearch bs1=new BinarySearch(array);
        int m=bs1.search(3);//返回的是查找到的数组的下标
        System.err.println(array[m]);
    }
}
class BinarySearch
{
    public int [] array;
    public int left;
    public int right;
    public int mid;
    //构造函数
    public BinarySearch(int [] array)
    {
        this.array=array;
        this.left=0;
        this.right=array.length-1;
    }
    public int search(int num)
    {
        while (right>=left)
        {
           mid=(right+left)/2;
           if(array[mid]==num)
           {
               return mid;
           }
           else
           {
               if(array[mid]<num)//查找的值大于mid,在mid1的右侧继续查找
               {
                left=mid+1;
               }
               else
               {
                 right=mid-1;
               }
           }
        }
        return mid;
    }
}
