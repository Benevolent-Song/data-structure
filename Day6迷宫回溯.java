//使用递归方法来实现
//对于递归的理解可以通过堆栈直观理解,最外层的程序在栈底,最内层的程序在栈顶,依次出栈执行
// println:此文本以字符串的形式作为参数传递给此方法,下一次打印从下一行开始
//print:此文本以字符串的形式作为参数传递给此方法,下一次打印接在后面
//printf:格式化输出的形式
/**
 * 迷宫的墙设为1,走过的通路设为2,走不通的路设为3
 * 迷宫的策略设为先右,再下,其次再向左,向上
 */
package com.shh;
public class Day6迷宫回溯 {
    public static void main(String[] args) {
        int[][] map = new int[7][8];//建立一个7*8的迷宫
        for (int i = 0; i < 8; i++)//将迷宫的上下边设为墙(执行完for下面的语句后才会i++)
        {
            map[0][i] = 1;
            map[6][i] = 1;
        }
        for (int i = 0; i < 7; i++)//将迷宫的左右墙设为墙
        {
            map[i][0] = 1;
            map[i][7] = 1;
        }
        for (int i=0;i<7;i++)//打印原始迷宫
        {
            for(int j=0;j<8;j++)
            {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
        map[3][1] = 1;//迷宫中间设立的墙
        map[3][2] = 1;
        setway(map, 1, 1);//从map[1][1]开始回溯
        for (int i=0;i<7;i++)//打印走出路径的迷宫
        {
            for(int j=0;j<8;j++)
            {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param map 是要进行操作的二维数组
     * @param i 开始回溯点的行
     * @param j 开始回溯点的列
     * @return
     */
    public static boolean setway(int[][] map, int i, int j) {
        if (map[5][6] == 2) {
            return true;
        } else {
            map[i][j] = 2;
            if (map[i + 1][j] == 0) {//尝试向下行进
                map[i + 1][j] = 2;
                setway(map, i + 1, j);
            } else if (map[i][j + 1] == 0) {//尝试向右行进
                map[i][j + 1] = 2;
                setway(map, i, j + 1);
            } else if (map[i - 1][j] == 0) {//尝试向上行进
                map[i - 1][j] = 2;
                setway(map, i - 1, j);
            } else if (map[i][j - 1] == 0) {//尝试向左行进
                map[i][j - 1] = 2;
                setway(map, i, j - 1);
            }
            return false;
        }
    }
}
