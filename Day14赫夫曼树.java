//赫夫曼树是为了得到带权路径长度最短的树,即得到最优二叉树，权值越大的点离父节点越近
//1) 从小到大进行排序，将每一个数据，每个数据都是一个节点，每个节点可以看成是一颗最简单的二叉树
//2) 取出根节点权值最小的两颗二叉树
//3) 组成一颗新的二叉树，该新的二叉树的根节点的权值是前面两颗二叉树根节点权值的和
//4) 再将这颗新的二叉树，以根节点的权值大小再次排序，不断重复 1-2-3-4 的步骤，直到数列中，所有的数据都被处理，就得到一颗赫夫曼树
//多个树的父节点进行大小排序，以最小父节点为子节点构成一个新的二叉树,该二叉树的父节点再次与剩下树的父节点进行排序
package com.shh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Day14赫夫曼树 {
    public static void main(String[] args) {
        int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
        Node root = createHuffmanTree(arr);//root是要构建的哈夫曼树的父节点,其值是所有路径之和
        preOrder(root); //前序遍历排好的赫夫曼树
    }
    //编写一个前序遍历的方法
    public static void preOrder(Node root) {
        if(root != null) {
            root.preOrder();
        }else{
            System.out.println("是空树，不能遍历~~");
        }
    }
    // 创建赫夫曼树的方法
     /**
     * @param arr 需要创建成哈夫曼树的数组
     * @return 创建好后的赫夫曼树的root结点
     */
    public static Node createHuffmanTree(int[] arr) {
        // 第一步为了操作方便
        // 1. 遍历 arr 数组
        // 2. 将arr的每个元素构成成一个Node
        // 3. 将Node 放入到ArrayList中
        List<Node> nodes = new ArrayList<Node>();
        //增强for循环,创建节点放入到集合nodes中
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        //我们处理的过程是一个循环的过程
        while(nodes.size() > 1) {
            //排序 从小到大
            Collections.sort(nodes);
            System.out.println("nodes =" + nodes);
            //取出根节点权值最小的两颗二叉树
            //(1) 取出权值最小的结点（二叉树）
            Node leftNode = nodes.get(0);
            //(2) 取出权值第二小的结点（二叉树）
            Node rightNode = nodes.get(1);
            //(3)构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //(4)从ArrayList删除处理过后不再需要的元素
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //(5)将parent加入到nodes,放在集合的尾部
            nodes.add(parent);
        }
        //返回哈夫曼树的root结点
        return nodes.get(0);
    }
}
// 创建结点类
// 为了让Node 对象持续排序Collections集合排序
// 让Node 实现Comparable接口,里面有实现排序的方法compareTo
class Node implements Comparable<Node> {
    int value; // 结点权值
    char c; //字符
    Node left; // 指向左子结点
    Node right; // 指向右子结点
    //写一个前序遍历
    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }
    public Node(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }
    //实现集合的从小到大的排序
    @Override
    public int compareTo(Node o) {
        // TODO Auto-generated method stub
        // 表示从小到大排序
        return this.value - o.value;
    }
}
