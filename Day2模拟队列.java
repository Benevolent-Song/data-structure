//队列遵循着先进先出的模式
//只允许在队尾插入，在队头删除(取出)
// 1.目前数组使用一次就不能用，没有达到复用的效果
// 2. 将这个数组使用算法，改进成一个环形的队列取模：%,可以达到复用的效果
package com.shh;
public class Day2模拟队列 {
    public static void main(String[] args) {
        list list1 = new list(3);//创建新的类,此时类中的数组队列的长度为3,最多添加3个元素
        list1.addnumber(15);
        list1.addnumber(9);
        list1.addnumber(1);
        list1.addnumber(89);//此时队列已经满了,不能再加入新的数据,会显示队列已满
        list1.takeallnumber();
    }
}
class list
{
    private int maxsize;
    private int front;//队列顶部的指针
    private int bottom;//队列底部的指针
    private int []arry;
    list(int arrymaxsize)//构造函数,用于初始化,可以有多个构造函数,但是需要形参参数不相同
    {
        maxsize=arrymaxsize;
        arry=new int[maxsize];
        front=-1;
        bottom=-1;
    }
    public boolean ifempt()
    {
        return front==bottom;//头指针和尾指针的地址相同表示栈中为空
    }
    public boolean iffull()
    {
        return front==maxsize-1;//头指针和盏的最大值-1相同说明栈中的元素满了
    }
    public int addnumber(int m)//添加是从栈的顶部添加的
    {
        if(!iffull())
        {
            front++;//对头指针加一使其指向随后要添加的那个元素上
            arry[front]=m;//对头指针指向的栈单元添加新的元素
        }
        else
        {
            System.out.println("队列满，不能加入数据~");
            return 0;
        }
        return arry[front];
    }
    public int takenumber()//取元素时是从栈的底部取出的
    {
        if(!ifempt())
        {
            bottom++;//对尾指针进行加一操作,使其准备取出下一个元素
            //System.out.printf("%d\t",arry[bottom]);
            return arry[bottom];
        }
        else
        {
            System.out.printf("队列空，不能取数据");
            return 0;
        }
    }
    public int takeallnumber()
    {
        if (!ifempt())
        {
         for(int i=0;i<arry.length;i++)
         {
             int m=0;
             m=takenumber();
             System.out.printf("%d\t",m);
             System.out.println();
         }
         return 1;
        }
        else
        {
            System.out.printf("队列空，不能取数据");
            return 0;
        }
    }
}