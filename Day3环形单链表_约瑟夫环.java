//使用环形单链表实现约瑟夫环,该链表没有头节点
//约瑟夫环:约瑟夫问题为：设编号为1，2，……n得n个人围坐一圈，
// 约定编号为k（k大于等于1并且小于等于n）的人从1开始报数，
// 数到m的那个人出列。它的下一位继续从1开始报数，数到m的人出列，
// 依次类推，直到所有人都出列为止。
package com.shh;
public class Day3环形单链表_约瑟夫环 {
    public static void main(String[] args)
    {
        circle circle1=new circle();
        //circle1.setcircle(5);//创建一个5个人的链表
        //circle1.showboy();
        circle1.countboy(1,2,5);//第几个开始数,每次数几个，最初的总人数
    }
}
class circle//环形单链表
{
    private node2 first=new node2(-1);//设置头指针
    public node2 boyarrow=new node2(-1);//尾指针,用于判断循环链表中的节点是否出完了(头指针=尾指针)
    public void setcircle(int num1)
    {
        //辅助指针,帮助构建环形链表
        if(num1<1)
        {
            System.out.println("无法构造环形链表,请重新输入");
            return;
        }
        for(int i=0;i<num1+2;i++)
        {
            node2 boy=new node2(i);
            if (num1==1)//当环形链表只有一个节点时
            {
                first.setNextNode(first);
            }
            else
            {
                if (i==1)
                {
                    first=boy;
                }
                boyarrow.next=boy;//
                boy.next=first;
                boyarrow=boy;
                //System.out.printf("小孩的编号 "+"%d\n",boyarrow.num);//\n为换行符
            }
        }
    }
    public void showboy()
    {
        node2 boyarrow=first;
        if(first.num==-1&&first.next==null)
        {System.out.printf("链表为空");}
        else {
            while (true) {
                System.out.printf("小孩的编号 " + "%d\n", boyarrow.num);
                boyarrow = boyarrow.getNextNode();
                if (boyarrow.next.num == first.num) {
                    System.out.printf("链表查询完毕\n");
                    break;
                }
            }
        }
    }
    /**
     *
     * @param startNo
     *            表示从第几个小孩开始数数
     * @param countNum
     *            表示数几下
     * @param nums
     *            表示最初有多少小孩在圈中
     */
    public void countboy(int startNo, int countNum, int nums)
    {
        if((startNo<0||countNum<0||nums<0)&&(nums>countNum)&&(startNo>nums))
        {
            System.out.printf("输入参数有误,请重新输入");
            return;
        }
        this.setcircle(nums-1);
        this.showboy();
        //确定头尾指针分别都在首尾了
        //System.out.printf("%d\n",first.num);//头指针的位置在1
        //System.out.printf("%d",boyarrow.num);//尾指针的位置在7
        for(int j = 0; j < startNo - 1; j++) //报数前，先让首尾指针first和boyarrow移动k-1次
        {
            first = first.next;
            boyarrow = boyarrow.next;
        }
        //小孩报数前，先让 first 和  helper 移动 k - 1次,将头指针移动到要开始的第startNo个链上,同时尾指针指向头指针的后一个链上
        for(int j = 0; j < startNo - 1; j++)
        {
            first = first.next;
            boyarrow = boyarrow.next;
        }
        //当小孩报数时，让first 和 helper 指针同时 的移动  m  - 1 次, 然后出圈
        //这里是一个循环操作，知道圈中只有一个节点
        while(true)
        {
            if(boyarrow == first) //头指针和尾指针重合,说明圈中只有一个节点
            {
                break;
            }
            //让 first 和 boyarrow 指针同时 的移动 countNum - 1
            for(int j = 0; j < countNum-1; j++)
            {
                first = first.next;
                boyarrow = boyarrow.next;
            }
            //这时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n", first.num);
            //这时将first指向的小孩节点出圈
            first = first.next;//对环型链表进行更新
            boyarrow.next=first;
        }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.num);
    }
}
class node2
{
    int num;//该节点的编号
    node2 next;//该节点指向的下一个节点
    public node2(int a)
    {
        this.num=a;
    }//节点的构造函数
    public int getnum()
    {
        return num;
    }
    public void setnum(int b)
    {
        this.num=b;
    }
    public node2 getNextNode()
    {
        return this.next;
    }
    public void setNextNode(node2 node)
    {
        this.next=node;
    }
    @Override
    public String toString()
    {
        return "HeroNode [no=" + num +"]";
    }
}
