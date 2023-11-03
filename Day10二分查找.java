//二分查找必须是要在顺序结构的数组里才能使用
//确定数组的起始下标left和结尾下标right,再确定中间下标mid=(right-left)/2
//目标值value与其进行比较大小,大则再再mid+1和left之间查找,使用递归得到最后要找的值
package com.shh;
import java.util.ArrayList;
import java.util.List;

public class Day10二分查找 {
    public static void main(String[] args) {
    int [] list={1,2,3,4,5,6,7};
    int indexvalue=search(list,0,list.length - 1,5);
    System.out.println(indexvalue);

    int [] list1={1,2,3,6,6,7,8};
    System.out.println(search2(list1,0,list.length - 1,6));
    }
    public static int search(int [] array,int left,int right,int goal)
    {
        int mid=(right+left)/2;
        int midvalue=array[mid];
        if(left>right)//查找完后仍然没有找到结果
        {
            return -1;
        }
        if(goal>midvalue)//向右递归
        {
            return search(array,mid+1,right,goal);
        }
        else if(goal<midvalue)//向左递归
        {
            return search(array,left,mid-1,goal);
        }
        else//此时goal=mid,得到了结果
        {
            return mid;
        }
    }

    //当数组中存在多个相同的目标值时存储到一个集合中
    public static List<Integer> search2(int [] array, int left, int right, int goal)
    {
        List <Integer> list1=new ArrayList<Integer>();
        int mid=(right+left)/2;
        int midvalue=array[mid];
        if(left>right)//查找完后仍然没有找到结果
        {
            return new ArrayList<Integer>();
        }
        if(goal>midvalue)//向右递归
        {
            return search2(array,mid+1,right,goal);
        }
        else if(goal<midvalue)//向左递归
        {
            return search2(array,left,mid-1,goal);
        }
        else//此时goal=mid,得到了结果
        {
            list1.add(mid);
            int temp=mid-1;
            while(true)
            {

              if (array[temp]!=goal||temp<0)
              {
                  break;
              }
                 list1.add(temp);
                 temp-=1;
            }
            temp=mid+1;
            while(true)
            {
                if (array[temp]!=goal||temp>array.length-1)
                {
                    break;
                }
                    list1.add(temp);
                    temp+=1;
            }
            return list1;
        }
    }
}
