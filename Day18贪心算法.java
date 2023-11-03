//贪心确定覆盖问题
//1.确定一个完全的集合2.遍历所有的子集合,寻找包含完全集合中最多元素的子集合,在将完全集合里包含这些的元素删去
//3.继续以这个删除了部分元素的完全集合继续重复上述步骤,直到找到所有的元素,即完全集合为空的时候
package com.shh;
import java.util.ArrayList;

public class Day18贪心算法 {
    public static void main(String[] args) {
        ArrayList <String> cityAll =new ArrayList<>();
        cityAll.add("北京");
        cityAll.add("上海");
        cityAll.add("天津");
        cityAll.add("广州");
        cityAll.add("深圳");
        cityAll.add("成都");
        cityAll.add("杭州");
        cityAll.add("大连");
        ArrayList <String> bc1 =new ArrayList<>();
        bc1.add("北京");
        bc1.add("上海");
        bc1.add("天津");
        ArrayList <String> bc2 =new ArrayList<>();
        bc2.add("广州");
        bc2.add("北京");
        bc2.add("深圳");
        ArrayList <String> bc3 =new ArrayList<>();
        bc3.add("成都");
        bc3.add("上海");
        bc3.add("杭州");
        ArrayList <String> bc4 =new ArrayList<>();
        bc4.add("上海");
        bc4.add("天津");
        ArrayList <String> bc5 =new ArrayList<>();
        bc5.add("杭州");
        bc5.add("大连");
        ArrayList <ArrayList>Broadcast=new <ArrayList>ArrayList();
        Broadcast.add(bc1);
        Broadcast.add(bc2);
        Broadcast.add(bc3);
        Broadcast.add(bc4);
        Broadcast.add(bc5);
        while(!cityAll.isEmpty()) //如果还没找到所有电台
        {
            int maxbc;//出现次数最多的电台
            int[] temp = new int[Broadcast.size()];//保存城市出现的次数
            ArrayList[] samecity = new ArrayList[Broadcast.size()];//(集合类型的数组)每个数组存放的是一个集合,每个集合存放出现相同的城市名
            for (int k = 0; k < Broadcast.size(); k++)//初始化集合,每次都要重新初始化,否者会出错
            {
                samecity[k] = new <String>ArrayList();
            }
            for (int i = 0; i < Broadcast.size(); i++)
            {
                for (int j = 0; j < Broadcast.get(i).size(); j++)//访问每一个集合出现的城市的个数和重复的名称
                {
                    if(cityAll.contains(Broadcast.get(i).get(j)))//如果包含相同的元素
                    {
                        temp[i]++;//统计出现的次数
                        samecity[i].add(Broadcast.get(i).get(j));//保存出现的城市名
                    }
                }
            }
            maxbc = max(temp);//返回出现最多城市名的集合
            System.out.println("选择电台bc"+(maxbc+1));//返回的下标是数组的,对应电台要加1
            for(int i=0;i<samecity[maxbc].size();i++)//将出现过了的城市给删除掉,为下一次判断作准备
            {
                cityAll.remove(samecity[maxbc].get(i));
            }
        }
    }
    //返回数组中的最大值所在的下标
    public static int max(int[] temp)
    {
        int m=0;//暂时存放最大值
        int n=0;//最大值所在的下标
        for(int i=0;i<temp.length;i++)
        {
          if(temp[i]>m)
          {
              n=i;
              m=temp[i];
          }
        }
        return n;
    }
}
