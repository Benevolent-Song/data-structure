//采用递归回溯的方法,8行8列的棋盘放置8个皇后所
// (第一个棋子一直在第一行移动,第二个棋子一直在第二行移动。。。。，后面的位置会被覆盖,不一定第n个棋子得到arry[n]的值)
//有放置皇后的过程都是一行一行来的，首先将第一行的皇后放在第一个位
//置，然后再看第二行。最开始也是将第二行的皇后放在第二行的第一个位
//置，发现冲突了，然后在移到第二行的第二个位置，还是冲突了，就再次
//移动，直到不与之前的皇后冲突，就开始进行下一行的放置以此类推。如
//果遇到了一整行都是与之前放置的皇后冲突的话就会从上一行里进行改变(即该种排列行不通了,要改变第一个皇后的位置)
//(比如在放第8行的皇后时，发现所有位置都不成立，那么他就会到第7行中，寻找符合的位置，再不行就到第6行里找，以此类推)
package com.shh;
public class Day7八皇后问题{
    static int max = 8; //一共8个皇后，定义初始值
    static int[] array = new int[max];//存放结果的数组,数组序号表示列数(0~8),数组元素表示行数(0~8)
    static int count=0;
    public static void main(String[] args)
    {
        put(0);//从第0个开始放置,其中产生了回溯
        System.out.print(count);
    }
    //结果输出方法
    private static void print() {
        System.out.print("[ ");
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i]+" ");
        }
        System.out.println("]");//println()输出完后换行
    }
    //检查放到第n个皇后时，是否与之前的皇后冲突
    private static boolean check(int n)
    {
        for (int i = 0; i < n; i++) //从第一个皇后开始检测
        {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i]))
            //array[i] == array[n]表示两个皇后在同一行
            //Math.abs(n - i) == Math.abs(array[n] - array[i])表示两个皇后的角度为45度,处于斜对角位置
            {
                return false;
            }
        }
        return true;
    }
    //放置第n个皇后
    //使用堆栈的方法理解回溯,在堆栈最上方执行的是put(8),底部是put(1)
    private static void put(int n){
        if(n == max) //因为下标是从0开始的，所以当n=8时代表再放就是第九个皇后了，就是已经放完了8个。直接打印结果即可。
        {
            count++;//表明已经放置完了一种8皇后,结果数加1
            print();//将此次的结果给打印出来
            return;//只要不满足条件了就帮助从嵌套的put()中退出来
        }
        for(int i=0;i<max;i++)//尝试在当前行的每个位置放置
        {
            array[n] = i;//后面的位置会被覆盖,不一定第n个棋子得到arry[n]的值
            if (check(n)){//检查放第n个皇后时是否冲突，不冲突的话就继续放置第n+1个。
                put(n+1);//放置第n+1个
            }
        }
    }
}
