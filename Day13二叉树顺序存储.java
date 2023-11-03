//将顺序存储为数组的二叉树，将数组重构为二叉树
//数组和二叉树元素的关系有相应的关系:
//1) 顺序二叉树通常只考虑完全二叉树
//2) 第 n 个元素的左子节点为 2 * n + 1
//3) 第 n 个元素的右子节点为 2 * n + 2
//4) 第 n 个元素的父节点为 (n-1) / 2
//利用上面的对应关系进行二叉树的前序,中序,后序遍历

package com.shh;
public class Day13二叉树顺序存储 {
    public static void main(String[] args) {
        int [] array={1,2,3,4,5,6,7};
        sxtree tree =new sxtree(array);
        tree.preorder(0);
        System.out.println("--------------------");
        tree.midorder(0);
        System.out.println("--------------------");
        tree.behindorder(0);
    }
}
//顺序存储在数组中二叉树
class sxtree
{
   public int [] array;
   //创建构造函数
   sxtree(int [] array)
   {
       this.array=array;
   }
   //对顺序存储在数组的二叉树进行前序遍历
   public void preorder(int index)
   {
       if(array==null||array.length==0)
       {
           System.out.println("该二叉树为空");
       }
       System.out.println(array[index]);
       if(index*2+1<array.length)//遍历左子树
       {
          preorder(index*2+1);
       }
       if(index*2+2<array.length)//遍历右子树
       {
           preorder(index*2+2);
       }
   }
    public void midorder(int index)
    {
        if(array==null||array.length==0)
        {
            System.out.println("该二叉树为空");
        }
        if(index*2+1<array.length)//遍历左子树
        {
            midorder(index*2+1);
        }
        System.out.println(array[index]);
        if(index*2+2<array.length)//遍历右子树
        {
            midorder(index*2+2);
        }
    }
    public void behindorder(int index)
    {
        if(array==null||array.length==0)
        {
            System.out.println("该二叉树为空");
        }
        if(index*2+1<array.length)//遍历左子树
        {
            behindorder(index*2+1);
        }
        if(index*2+2<array.length)//遍历右子树
        {
            behindorder(index*2+2);
        }
        System.out.println(array[index]);

    }
}
