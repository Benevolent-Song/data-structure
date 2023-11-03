//是图结构的应用,从一个顶点开始处理,找到它所有相连的节点,在这些节点中找到距离最短的节点
//将确定的节点都标记为访问过,再以这些节点出发,找到还没访问过中最短的加入
//图存储的关系为二维邻接矩阵
//老师写的三层for循环要更好
package com.shh;

import java.util.ArrayList;
import java.util.Arrays;

public class Day18普利姆算法Prim {
    public static void main(String[] args) {
      int [][] array=new int [7][7];
      String [] hometown={"A","B","C","D","E","F","G"};//对应二维矩阵索引的0~6
      grah grah1=new grah(array,hometown);
      //A:0 B:1 C:2 D:3 E:4 F:5 G:6
      //AB5 AC7 AG2 BD9 BG3 CE8 EG4 EF5 FD4 GF6
        grah1.add(0,1,5);
        grah1.add(0,2,7);
        grah1.add(0,6,2);
        grah1.add(1,3,9);
        grah1.add(1,6,3);
        grah1.add(2,4,7);
        grah1.add(3,5,4);
        grah1.add(4,6,4);
        grah1.add(4,5,5);
        grah1.add(5,6,6);
        grah1.show();
        grah1.prim();
    }
}
class grah
{
    int [][] array;
    String [] hometown;//索引对应的字符
    int [] if_find;//是否被找到过了
    ArrayList findhometown;//确定找到的村庄
    ArrayList findhometown_temp;//所有子节点中最小的一个节点
    ArrayList findhometown_temp_temp;//一个节点的所有的子节点
    int distance;//总的距离
    public grah(int [][]array,String [] hometown)
    {
        this.array=array;
        this.hometown=hometown;
        this.if_find=new int[array.length];
        this.findhometown=new ArrayList();
        this.findhometown_temp=new ArrayList();
        this.findhometown_temp_temp=new ArrayList();
        add1();
        this.distance=0;
        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j<array[i].length;j++)
            {
               array[i][j]=10000;
            }
        }
    }
    public void add(int a,int b,int height)
    {
        array[a][b]=height;
        array[b][a]=height;
    }
    public void show()
    {
        for(int []i:array)
        {
            System.out.println(Arrays.toString(i));
        }
    }
    public String findhometown(int index)
    {
        return hometown[index];
    }
    public void prim()//普利姆算法的实现,从下标为0的节点开始
    {
        if_find[0]=1;
        findhometown.add(0);//从A节点开始修路
        System.out.print(findhometown(0)+"——>");
        while(findhometown.size()<array.length)//n个城市相互连通需要修n-1条路,即要找到n-1个城市
        {
            for(int i=0;i<findhometown.size();i++)
            {
                findnext((Integer) findhometown.get(i));//找到所有确定城市的下一个没有被访问过的节点城市
            }
            //找到findhometown_temp中最短距离的村庄,if_find设为1,并且加入到findhometown中,并且添加上距离
            int temp=10000;
            int index_temp=0;
            for(int m=0;m<findhometown_temp.size();m++)
            {
                if((int)findhometown_temp.get(m)<temp)
                {
                    temp=(int)findhometown_temp.get(m);//最小值的数值
                    index_temp=m;//最小值的下标
                }
            }
            System.out.print("("+temp+")"+findhometown(index_temp)+"——>");//打印下次要取的路径
            if_find[index_temp]=1;//城市设为访问过了
            findhometown.add(index_temp);//加入到找到的城市中
            distance=distance+temp;//此时公路的距离长度
            findhometown_temp.clear();//清空所有找到的最短的节点
            add1();
        }
        System.out.println("完成");
        System.out.println("修路总长度为"+distance+"公里");
    }
    //查找节点的下一可以访问的节点
    public void findnext(int index)
    {
       for(int i=0;i<array.length;i++)
       {
         if(array[index][i]!=10000&&if_find[i]!=1)//如果是没有被访问过的而且是连通的
         {
            findhometown_temp_temp.set(i,array[index][i]);//区分add和set,add是插入,set是替换
         }
       }
       //找出其中最小的值和它的下标
        int temp=10000;
        int index_temp=0;
        for (int m=0;m<findhometown_temp_temp.size();m++)
        {
           if((int)findhometown_temp_temp.get(m)<temp)
           {
               temp=(int)findhometown_temp_temp.get(m);//最小值的数值
               index_temp=m;//最小值的下标
           }
        }
        clear();//清空findhometown_temp_temp,方便下次使用
        add1();
        findhometown_temp.set(index_temp,temp);
    }
    public void clear()
    {
        for(int i=0;i<8;i++)
        {
            findhometown_temp_temp.clear();
            findhometown_temp_temp.add(10000);
            findhometown_temp_temp.add(10000);
            findhometown_temp_temp.add(10000);
            findhometown_temp_temp.add(10000);
            findhometown_temp_temp.add(10000);
            findhometown_temp_temp.add(10000);
            findhometown_temp_temp.add(10000);
            findhometown_temp_temp.add(10000);
        }
    }
    public void add1()
    {
        for(int i=0;i<8;i++)
        {
            findhometown_temp_temp.add(10000);
            findhometown_temp_temp.add(10000);
            findhometown_temp_temp.add(10000);
            findhometown_temp_temp.add(10000);
            findhometown_temp_temp.add(10000);
            findhometown_temp_temp.add(10000);
            findhometown_temp_temp.add(10000);
            findhometown_temp_temp.add(10000);
            findhometown_temp.add(10000);
            findhometown_temp.add(10000);
            findhometown_temp.add(10000);
            findhometown_temp.add(10000);
            findhometown_temp.add(10000);
            findhometown_temp.add(10000);
            findhometown_temp.add(10000);
            findhometown_temp.add(10000);
        }
    }
}
/**老师写的代码,更简洁
public class PrimAlgorithm {

    public static void main(String[] args) {
        //测试看看图是否创建ok
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};

        //创建MGraph对象
        MGraph graph = new MGraph(verxs);
        //创建一个MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        //输出
        minTree.showGraph(graph);
        //测试普利姆算法
        minTree.prim(graph, 1);//
    }

}
*/
/**
//创建最小生成树->村庄的图
class MinTree {
    //创建图的邻接矩阵
    /**
     *
     * @param graph 图对象
     * @param verxs 图对应的顶点个数
     * @param data 图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
  /**
    public void createGraph(MGraph graph, int verxs, char data[], int[][] weight) {
        int i, j;
        for(i = 0; i < verxs; i++) {//顶点
            graph.data[i] = data[i];
            for(j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示图的邻接矩阵
    public void showGraph(MGraph graph) {
        for(int[] link: graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    //编写prim算法，得到最小生成树
    /**
     *
     * @param graph 图
     * @param v 表示从图的第几个顶点开始生成'A'->0 'B'->1...
     */
  /**
    public void prim(MGraph graph, int v) {
        //visited[] 标记结点(顶点)是否被访问过
        int visited[] = new int[graph.verxs];
        //visited[] 默认元素的值都是0, 表示没有访问过
//		for(int i =0; i <graph.verxs; i++) {
//			visited[i] = 0;
//		}

        //把当前这个结点标记为已访问
        visited[v] = 1;
        //h1 和 h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000; //将 minWeight 初始成一个大数，后面在遍历过程中，会被替换
        for(int k = 1; k < graph.verxs; k++) {//因为有 graph.verxs顶点，普利姆算法结束后，有 graph.verxs-1边

            //这个是确定每一次生成的子图 ，和哪个结点的距离最近
            for(int i = 0; i < graph.verxs; i++) {// i结点表示被访问过的结点
                for(int j = 0; j< graph.verxs;j++) {//j结点表示还没有访问过的结点
                    if(visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        //替换minWeight(寻找已经访问过的结点和未访问过的结点间的权值最小的边)
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条边是最小
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            //将当前这个结点标记为已经访问
            visited[h2] = 1;
            //minWeight 重新设置为最大值 10000
            minWeight = 10000;
        }

    }
}

class MGraph {
    int verxs; //表示图的节点个数
    char[] data;//存放结点数据
    int[][] weight; //存放边，就是我们的邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
*/
