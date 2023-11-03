//1) 平衡二叉树也叫平衡二叉搜索树又被称为AVL树,可以保证查询效率较高。
//2) 具有以下特点:它是一棵空树或它的左右两个子树的高度差的绝对值不超过1,并且左右两个子树都是一棵平衡二叉树。
//3) 平衡二叉树的常用实现方法有红黑树、AVL(算法,和AVL树的AVL不一样)、替罪羊树、Treap、伸展树等。
//   平衡情况分为三种:操作时的this始终是根节点,即数组的第一个元素  1.左旋转(步骤固定)  2.右旋转(步骤固定)
//   3.双旋转(右子树的左子树的高度大于它的右子树的右子树的高度;左子树的右子树高度大于它的左子树的高度)(先左旋转再右旋转;先右旋转再左旋转),该情况包含在1,2中

package com.shh;
import java.util.ArrayList;
import java.util.List;

public class Day16平衡二叉树 {
    public static void main(String[] args) {
      int [] array={10, 11, 7, 6, 8, 9};
      AVLtree AVLTree = new AVLtree(array);
      AVLTree.CreateAvlTree();
      //判断节点是否被保存了
      System.out.println("---------------------------");
        AVLTree.infixOrder();//中序遍历平衡二叉序树
      System.out.println("---------------------------");
      System.out.println(AVLTree.root.leftheight());//左子树深度
      System.out.println(AVLTree.root.rightheight());//右子树深度
    }
}
class AVLtree
{
    public int [] array;
    public AVLnode root;//根节点
    List<AVLnode> AvlList=new ArrayList<AVLnode>();
    AVLtree(int [] array)
    {
        this.array=array;
        for(int i=0;i<array.length;i++)
        {
            AvlList.add(new AVLnode(array[i]));
        }
        root=AvlList.get(0);//确定根节点
    }
    public void addnode(AVLnode AVLnode)
    {
        if(root == null) {
            root = AVLnode;//如果root为空则直接让root指向node
        } else {
            root.add(AVLnode);
        }
    }
    public void CreateAvlTree()
    {
        for(int i=0;i<array.length;i++)
        {
            this.addnode(AvlList.get(i));
        }
    }
    public void infixOrder() {
        if(root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空，不能遍历");
        }
    }
}
class AVLnode
{
    public AVLnode left;
    public AVLnode right;

    public int value;
    AVLnode(int value)
    {
       this.value=value;
    }
    //求节点树的深度
    public int height()
    {
       //+1才能统计出经过了几次height()
       return Math.max(this.left==null?0:this.left.height(),this.right==null?0:this.right.height())+1;//当前节点树的深度
    }
    //左子树的深度
    public int leftheight()
    {
     if(this.left==null)
     {
       return 0;
     }
     else
     {return this.left.height();}
    }
    //右子树的深度
    public int rightheight()
    {
        if(this.right==null)
        {
            return 0;
        }
        else
        {return this.right.height();}
    }
    //中序遍历树
    public void infixOrder() {
        if(this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if(this.right != null) {
            this.right.infixOrder();
        }
    }
    public void add(AVLnode AVLnode)
    {
        if(AVLnode == null) {
            return;
        }
        if(this.value<AVLnode.value)//如果大于当前节点放到右子节点
        {
           if(this.right==null)
           {
              this.right=AVLnode;
           }
           else
           {
               this.right.add(AVLnode);
           }
        }
        if(this.value>AVLnode.value)//如果小于当前节点放到左子节点
        {
            if(this.left==null)
            {
                this.left=AVLnode;
            }
            else
            {
                this.left.add(AVLnode);
            }
        }
        //当添加完一个结点后，如果: (右子树的高度-左子树的高度) > 1 , 左旋转
        if(rightheight() - leftheight() > 1) {
            //如果它的右子树的左子树的高度大于它的右子树的右子树的高度
            if(this.right != null && this.right.leftheight() > this.right.rightheight())
            {this.right.rightRotate(); leftRotate();}//双旋转
            else {leftRotate();}
            return ; //必须要!!!
        }
        //当添加完一个结点后，如果 (左子树的高度 - 右子树的高度) > 1, 右旋转
        if(leftheight() - rightheight() > 1) {
           //如果它的左子树的右子树高度大于它的左子树的高度
            if(this.left != null && this.left.rightheight() > this.left.leftheight())
            {this.left.leftRotate();rightRotate();}//双旋转
            else {rightRotate();}
        }
    }
    //右子树深度大于左子树,进行左旋转
    private void leftRotate() {
        //创建新的结点，以当前根结点的值
        AVLnode newNode = new AVLnode(value);
        //把新的结点的左子树设置成当前结点的左子树
        newNode.left = this.left;
        //把新的结点的右子树设置成带你过去结点的右子树的左子树
        newNode.right = this.right.left;
        //把当前结点的值替换成右子结点的值
        this.value = this.right.value;
        //把当前结点的右子树设置成当前结点右子树的右子树
        this.right = this.right.right;
        //把当前结点的左子树(左子结点)设置成新的结点
        this.left = newNode;
    }
    //左子树深度大于右子树,进行右旋转
    private void rightRotate() {
        AVLnode newNode = new AVLnode(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }
}
