//双链表结构相较与单链表区别在于它还存有前一个节点(地址)
package com.shh;
public class Day3双向链表 {
    public static void main(String[] args) {
        node1 people1 = new node1(1, "林冲", "豹子头");
        node1 people2 = new node1(2, "鲁智深", "黑旋风");
        node1 people3 = new node1(3, "宋江", "及时雨");
        nodemanage1 nodemanage1 = new nodemanage1();
        System.out.println("添加-----------------------------------------");
        nodemanage1.add(people1);//将数据添加到单链表中
        nodemanage1.add(people2);
        nodemanage1.add(people3);
        nodemanage1.list();
        System.out.println("更新-----------------------------------------");
        node1 people4 = new node1(4, "宋海豪", "及时雨");//进行数据更新
        nodemanage1.update(3,people4);
        nodemanage1.list();
        System.out.println("删除-----------------------------------------");
        nodemanage1.delet(4);
        nodemanage1.delet(2);
        nodemanage1.list();
    }
}
class nodemanage1//双链表结构,用于多个节点的管理
{
    private node1 head=new node1(0,"","");//私有头指针,不能被改变
    node1 temp=head;
    public void add(node1 node1)//将节点添加到单链表的最后位置
    {
        while (true)
        {
            if(temp.next==null)
            {
                temp.next=node1;
                node1.pre=temp;
                break;
            }
            temp=temp.next;
        }
    }
    public void list()//显示单链表中的所有节点信息
    {
        node1 temp=head;
        if(temp.next==null)
        {
            System.out.println("双链表为空");
        }
        while (true)
        {
            if (temp.next==null)
            {
                break;
            }
            System.out.println(temp.next);
            temp=temp.next;
        }
    }
    public void update(int newnum, node1 newnode)//对特定编号的节点数据更新
    {
        node1 temp=head;
        while(true)
        {
            if(temp.next==null)
            {
                System.out.println("未找到,更新失败");
                break;
            }
            if(temp.next.number==newnum)
            {
                newnode.next=temp.next.next;
                temp.next=newnode;
                newnode.pre= temp;
                break;
            }
            temp=temp.next;
        }
    }
    public void delet(int delnum)//删除指定位置的节点
    {
        node1 temp=head;
        while(true)
        {
            if(temp.next==null)
            {
                System.out.println("未找到,删除");
                break;
            }
            if(temp.next.number==delnum)
            {
                if(temp.next.next==null)
                {
                    temp.next=null;
                }
                else
                {
                    temp.next=temp.next.next;
                    temp.next.next.pre=temp;
                }
                break;
            }
            temp=temp.next;
        }
    }
}
class node1//用于存放单个双链表节点的信息
{
    int number;
    String name;
    String nickname;
    node1 next;
    node1 pre;
    public node1(int a, String b, String c)
    {
        this.number=a;
        this.name=b;
        this.nickname=c;
    }
    @Override
    public String toString() {
        return "HeroNode [no=" + number + ", name=" + name + ", nickname=" + nickname + "]";
    }
}
