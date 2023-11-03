//图的深度优先,一条路走到黑,找不到了再返回
//图的广度优先,每次取同层的下一个节点
//动图理解 http://qclog.cn/1217
package com.shh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Day17图的深度和广度遍历 {

    private ArrayList<String> vertexList; //存储顶点集合
    private int[][] edges; //存储图对应的邻结矩阵
    private int numOfEdges; //表示边的数目
    private boolean[] isVisited;//定义给数组boolean[], 记录对应结点是否被访问,true是被访问过了

    public static void main(String[] args) {
        int n = 8;  //结点的个数
        String Vertexs[] = {"A", "B", "C", "D", "E", "F", "G", "H"};

        //创建图对象
        Day17图的深度和广度遍历 graph1 = new Day17图的深度和广度遍历(n);
        //循环的添加顶点到集合vertexList中
        for(String vertex: Vertexs) {
            graph1.insertVertex(vertex);
        }

        //设置边的关系
        graph1.insertEdge(0, 1, 1);
        graph1.insertEdge(0, 2, 1);
        graph1.insertEdge(1, 3, 1);
        graph1.insertEdge(1, 4, 1);
        graph1.insertEdge(3, 7, 1);
        graph1.insertEdge(4, 7, 1);
        graph1.insertEdge(2, 5, 1);
        graph1.insertEdge(2, 6, 1);
        graph1.insertEdge(5, 6, 1);

        //显示构造好了的邻结矩阵
        graph1.showGraph();

        //测试一把，我们的dfs遍历是否ok
        System.out.println("深度遍历:");
        graph1.dfs(); // A=>B=>D=>H=>E=>C=>F=>G [1->2->4->8->5->3->6->7]
		System.out.println();
        System.out.println("广度优先:");
        graph1.bfs(); // A=>B=>C=>D=>E=>F=>G=>H [1->2->3->4->5->6->7->8]

    }

    //构造器
    public Day17图的深度和广度遍历(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }

    /**
     * @param index 是要查询下一邻节点的节点
     * @return 如果存在(有连接关系,即邻接表有置数)就返回对应的下标，否则返回-1
     */
    //得到第一个邻接结点的下标,没有邻接节点则返回-1
    public int getFirstNeighbor(int index) {
        for(int j = 0; j < vertexList.size(); j++) {
            if(edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //v1是当前访问的节点,v2是下一个临接节点,但是被访问过了,所以要从v2开始访问下一个v1的邻接节点,没有了则返回-1
    public int getNextNeighbor(int v1, int v2) {
        for(int j = v2 + 1; j < vertexList.size(); j++) {
            if(edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    //i 第一次就是 0
    //调用一次是访问到最深处为止,还是不够的还需要将所有未访问的节点访问,所以有下面重载的dfs()函数
    private void dfs(boolean[] isVisited, int i)
    {
        //首先我们访问该结点,输出
        System.out.print(getValueByIndex(i) + "=>");
        //将结点设置为已经访问
        isVisited[i] = true;//更新访问的情况
        //查找结点i的第一个邻接结点w
        int w = getFirstNeighbor(i);
        while(w != -1)//说明有临接节点存在,递归调用,访问完一个完全的的邻接节点
        {
            //如果没有被访问过
            if(!isVisited[w])
            {
            dfs(isVisited, w);//继续访问所有的邻接节点以及它们的邻接节点,访问到最深处
            }
            //如果w结点已经被访问过,查找当前节点的下一个邻接节点,直到该节点没有邻接节点
            w = getNextNeighbor(i, w);
        }
    }
    //真正进行完整的dft的函数
    //如果邻接节点不存在,对dfs进行一个重载, 遍历我们所有的结点,并进行dfs
    public void dfs() {
        //存放每个节点的访问情况
        isVisited = new boolean[vertexList.size()];
        //遍历所有的结点，进行dfs[回溯]
        for(int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //对一个结点进行广度优先遍历的方法
    private void bfs(boolean[] isVisited, int i) {
        int u ; // 表示队列的头结点对应下标
        int w ; // 邻接结点w
        //队列，记录结点访问的顺序
        LinkedList queue = new LinkedList();
        //访问结点，输出结点信息
        System.out.print(getValueByIndex(i) + "=>");
        //标记为已访问
        isVisited[i] = true;
        //将结点加入队列(队列从尾部加入,从头部取出)
        queue.addLast(i);
        while( !queue.isEmpty()) {
            //取出队列的头结点下标(由于返回类型为Object,需要转换为包装类)
            u = (Integer)queue.removeFirst();
            //得到第一个邻接结点的下标 w
            w = getFirstNeighbor(u);
            while(w != -1) {//找到
                //是否访问过
                if(!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "=>");
                    //标记已经访问
                    isVisited[w] = true;
                    //入队
                    queue.addLast(w);
                }
                //以u为前驱点，找出u的邻接节点w后面的下一个u的邻结点
                w = getNextNeighbor(u, w); //体现出我们的广度优先
            }
        }
    }

    //遍历所有的结点，都进行广度优先搜索
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for(int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    //返回结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //显示图对应的矩阵
    public void showGraph() {
        for(int[] link : edges) //每次取出来的是一个一维矩阵
        {
            System.out.println(Arrays.toString(link));//显示一维矩阵,System.err.println显示的是红色的
        }
    }
    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }
    //返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }
    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }
    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }
    //添加边
    /**
     *
     * @param v1 表示点的下标即使第几个顶点  "A"-"B" "A"->0 "B"->1
     * @param v2 第二个顶点对应的下标
     * @param weight 表示
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
