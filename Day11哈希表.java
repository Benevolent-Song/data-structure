//哈希表是由多条链表构成的,每条链表都由相同的(哈希函数=id%size)值来分组的
//hashlist是单个链表,hashTab是由多个链表组成的哈希表
package com.shh;
public class Day11哈希表{
    public static void main(String[] args)
    {
        hashTab hashTab1=new hashTab(7);
        Emp emp1=new Emp(2,"宋海豪");
        Emp emp2=new Emp(3,"宋海媚");
        Emp emp3=new Emp(4,"宋海轮");
        hashTab1.add(emp1);
        hashTab1.add(emp2);
        hashTab1.add(emp3);
        hashTab1.find(2);
        hashTab1.find(3);
        hashTab1.find(4);
        hashTab1.find(6);
        System.out.println("---------------------------------");
        hashTab1.list();
    }
}
//创建员工类
class Emp
{
    public int id;
    public String name;
    public Emp next;
    //构造函数
    Emp(int id,String name)
    {
      super();
      this.id=id;
      this.name=name;
    }
}
//创建链表
class hashlist
{
    private Emp head;//默认为null
    //链表添加成员
    public void add(Emp emp)
    {
        if (head==null)//如果链表为空则直接放入链表
        {
            head=emp;
            return;
        }
        Emp emp1=head;
       while(true)
        {
            if(emp1.next==null)//直到找到链表最后的位置
            {
                break;
            }
            emp1=emp1.next;
        }
        emp1.next=emp;//此时已经在链表的最后一个位置上了
    }
    //根据id值查询员工
    public Emp find(int id)
    {
       if (head==null)
       {
           System.out.println("没有查询到结果");
           return head;
       }
       else
       {
           Emp emp2=head;
           while(true)
           {
              if (emp2.id==id)
              {
                  System.out.printf("id=%d  name=%s \n",emp2.id,emp2.name);
                  return emp2;
              }
              if (emp2.next==null)
              {
                  System.out.println("没有查询到结果");
                  return emp2;
              }
               emp2= emp2.next;
           }
       }
    }
    //列出链表中的所有员工
    public void list()
    {
       if(head==null)
       {
           System.out.println("当前链表为空");
       }
       else
       {
           Emp emp3=head;
           while (true)
           {
               System.out.printf("id=%d  name=%s \n",emp3.id,emp3.name);
               if(emp3.next==null)
               {
                   break;
               }
               emp3=emp3.next;
           }
       }
    }
}
//创建哈希表
class hashTab
{
    private int size;
    public hashlist[] hasharray;
    //构造函数
    public hashTab(int size)
    {
        this.size=size;
        //确定hasharray的长度,但是没有初始化数组
        hasharray=new hashlist[size];
        //！！！非常重要的一步,需要对hasharray数组每个元素进行创建
        for(int i = 0; i < size; i++) {
            hasharray[i] = new hashlist();
        }
    }
    //通过哈希函数确定属于哪一个链表
    public int hashfun(int id)
    {
        int hashno=id%size;
        return hashno;
    }
    //添加员工到哈希表中
    public void add(Emp emp)
    {
        int no1=hashfun(emp.id);//确定在哈希表的哪条链表中
        this.hasharray[no1].add(emp);
    }
    //查询员工信息
    public void find(int id)
    {
        int no2=hashfun(id);//确定在哈希表的哪条链表中
        this.hasharray[no2].find(id);
    }
    public void list()
    {
        for (int i=0;i<size;i++)
        {
            hasharray[i].list();
        }
    }
}

