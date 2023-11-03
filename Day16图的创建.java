//图的存储有两种方式1.二维矩阵,有连线的矩阵元素为1(浪费空间)  2.链表表示,有连线的形成一组链表
//这里创建的是无向图
package com.shh;
import java.util.ArrayList;
import java.util.Arrays;

public class Day16图的创建 {
    public static void main(String[] args) {
        String [] array= new String[]{"A", "B", "C", "D"};//自动分别编号为了0~3
        Day16图的创建 A1=new Day16图的创建(4);
        for(int i=0;i<array.length;i++)
        {
           A1.insert(array[i]);
        }
        //创建节点间的关系
        A1.setEdge(0,1,1);
        A1.setEdge(1,2,1);
        A1.setEdge(2,3,1);
        A1.show();
        System.err.println(A1.relation(2));
        //获取下标和字母的关系,System.err.println显示的是红色的
    }
    public ArrayList<String>graph;
    public int [] [] edge;
    Day16图的创建(int n)
    {
        graph=new ArrayList<String>(n);
        edge=new int [n][n];
    }
    public void insert(String graph1)
    {
        graph.add(graph1);
    }
    //将二维数组中元素有连线的元素的二维数据写入权值weigth表示连接
    //权值可以用其它表示,可以无穷表示无连接,有限值表示路径的权值,可以根据自己设置
    public void setEdge(int n,int m,int weigth)
    {
       edge[n][m]=weigth;
       edge[m][n]=weigth;
    }
    //返回下标对应的字符
    public String relation(int index)
    {
        return graph.get(index);
    }
    //打印边关系的二维数组
    //arr.length代表的是二维数组的行
    //arr[0].length是二维数组的列。
    public void show()
    {
        for(int i=0;i< edge.length;i++)
        {
            for(int j=0;j< edge[0].length;j++)
            {
               System.out.print(edge[i][j]);
               System.out.print("  ");
            }
               System.out.println();
        }
         /**也可以写成增强for循环
         * for(int [] i:edge)//每次取出来的是一个数组
         * {
         *   System.err.println(Array.toString(i));//打印出来是红色的,其它是一样的
         * }
         */
    }
}
