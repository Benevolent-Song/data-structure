//Day1
//数据结构概念的笔记都在https://blog.csdn.net/chongyang_/article/details/109544719里面
//二维数组和稀疏表的相互转换
//概念：稀疏表用于非0值较少的二维数组,简略保存二维数组的信息
package com.shh;
public class Day1稀疏表 {
    static int m=0;
    public static void main(String[] args) {
        //----二维数组转化为稀疏表
        int arry1[][]=new int [11][11];
        arry1[0][5]=13;
        arry1[5][7]=8;
        //遍历查找有多少个不同的元素
        for(int i=0;i<11;i++)
        {
            for(int j=0;j<11;j++)
            {
                if (arry1[i][j]!=0)
                {
                   m++;
                }
            }
        }
        //创建原始稀疏表
        int arry2[][]=new int [m+1][3];
        arry2[0][0]=11;
        arry2[0][1]=11;
        arry2[0][2]=m;
        m=0;
        //将数据的值以及行列信息保存到稀疏表当中
        for(int i=0;i<11;i++)
        {
            for(int j=0;j<11;j++)
            {
                if (arry1[i][j]!=0)
                {
                    m++;
                    arry2[m][0]=i;
                    System.out.println(arry2[m][0]);
                    arry2[m][1]=j;
                    System.out.println(arry2[m][1]);
                    arry2[m][2]=arry1[i][j];
                    System.out.println(arry2[m][2]);
                }
            }
        }
        //for in语句打印出二维数组
        for(int []list:arry2)//一维数组list[]遍历二维数组arry2[][]的每一行
        {
            for (int data:list)//将二维数组的每一列的一维数组list[]进行遍历
            {
                System.out.printf("%d\t",data);//进行打印
            }
            System.out.println();
        }
        //-----稀疏表转换为二维数组
        int[][] arry3 =new int[arry2[0][0]][arry2[0][1]];
        for(int q=0;q<arry2[0][2];q++)
        {
            arry3[arry2[q+1][0]][arry2[q+1][1]]=arry2[q+1][2];
            System.out.println(arry3[arry2[q+1][0]][arry2[q+1][1]]);
        }
        //for in语法结构,打印出二维数组
        for(int []list1:arry3)
        {
            for (int data:list1)
            {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
