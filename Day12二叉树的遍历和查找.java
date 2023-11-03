//使用递归调用来实现遍历
//前序遍历(根左右)
//中序遍历(左根右)
//后序遍历(左右根)
package com.shh;
public class Day12二叉树的遍历和查找 {
    public static void main(String[] args) {
        treenode treenode1 =new treenode(1,"宋海豪");//头节点
        treenode treenode2 =new treenode(2,"宋海媚");
        treenode treenode3 =new treenode(3,"宋海伦");
        treenode treenode4 =new treenode(4,"宋迟兴");
        tree tree1=new tree(treenode1);
        treenode1.left= treenode2;
        treenode1.right= treenode3;
        treenode3.right= treenode4;
        //遍历
        tree1.preorder();
        System.out.println("-------------------------------");
        tree1.midorder();
        System.out.println("-------------------------------");
        tree1.behindorder();
        System.out.println("-------------------------------");
        //查询
        tree1.preorderfind(3);
        System.out.println("-------------------------------");
        tree1.midorderfind(3);
        System.out.println("-------------------------------");
        tree1.behindorderfind(3);
        System.out.println("-------------------------------");
    }
}
//创建树类
class tree
{
    public treenode head;
    public tree(treenode treenode)
    {
        this.head= treenode;
    }
    public void preorder()
    {
        if(head==null)
        {
            System.out.println("当前树为空,无法遍历");
        }
        else {
            head.preorder();
        }
    }
    public void preorderfind(int id)
    {
        if(head==null)
        {
            System.out.println("当前树为空,无法遍历");
        }
        else {
            head.preorderfind(id);
        }
    }
    public void midorder()
    {
        if(head==null)
        {
            System.out.println("当前树为空,无法遍历");
        }
        else {
            head.midorder();
        }
    }
    public void midorderfind(int id)
    {
        if(head==null)
        {
            System.out.println("当前树为空,无法遍历");
        }
        else {
            head.midorderfind(id);
        }
    }
    public void behindorder()
    {
        if(head==null)
        {
            System.out.println("当前树为空,无法遍历");
        }
        else {
            head.behindorder();
        }
    }
    public void behindorderfind(int id)
    {
        if(head==null)
        {
            System.out.println("当前树为空,无法遍历");
        }
        else {
            head.behindorderfind(id);
        }
    }
}
//创建节点类
class treenode
{
    public int id;
    public String name;
    public treenode left;//左子树
    public treenode right;//右子树
    //构造函数
    treenode(int id, String name)
    {
        this.id=id;
        this.name=name;
    }
    //前序遍历
    public void preorder()
    {
        System.out.printf("id=%d  name=%s \n",this.id,this.name);
        if(this.left!=null)
        {
            this.left.preorder();
        }
        if(this.right!=null)
        {
            this.right.preorder();
        }
    }
    //前序查找
    public void preorderfind(int id)
    {
        if(this.id==id)
        {
            System.out.printf("id=%d  name=%s",this.id,this.name);
            System.out.println();
        }
        if(this.left!=null)
        {
            this.left.preorderfind(id);
        }
        if(this.right!=null)
        {
            this.right.preorderfind(id);
        }
    }
    //中序遍历
    public void midorder()
    {
        if(this.left!=null)
        {
            this.left.midorder();
        }
        System.out.printf("id=%d  name=%s \n",this.id,this.name);
        if(this.right!=null)
        {
            this.right.midorder();
        }
    }
    //中序查找
    public void midorderfind(int id)
    {
        if(this.left!=null)
        {
            this.left.midorderfind(id);
        }
        if(this.id==id)
        {
            System.out.printf("id=%d  name=%s",this.id,this.name);
            System.out.println();
        }
        if(this.right!=null)
        {
            this.right.midorderfind(id);
        }
    }
    //后序遍历
    public void behindorder()
    {
        if(this.left!=null)
        {
            this.left.behindorder();
        }
        if(this.right!=null)
        {
            this.right.behindorder();
        }
        System.out.printf("id=%d  name=%s \n" ,this.id,this.name);
    }
    //后序查找
    public void behindorderfind(int id)
    {
        if(this.left!=null)
        {
            this.left.behindorderfind(id);
        }
        if(this.right!=null)
        {
            this.right.behindorderfind(id);
        }
        if(this.id==id)
        {
            System.out.printf("id=%d  name=%s",this.id,this.name);
            System.out.println();
        }
    }
}
