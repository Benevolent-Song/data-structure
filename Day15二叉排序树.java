//  BST树,任意一个节点,它的左子节点小于它,右子节点大于它
//  以数组的第一个元素作为BST树的父节点,数组后面的元素判断与父节点的大小关系
//  大的放在父节点的右侧,并判断下一个节点是否为空,为空直接插入,不为空则递归调用直达为空后插入

package com.shh;

public class Day15二叉排序树{
    public static void main(String[] args) {
    int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
    BinarySortTree binarySortTree = new BinarySortTree();
    //循环的添加结点到二叉排序树
    for(int i = 0; i< arr.length; i++) {
        binarySortTree.add(new BSTnode(arr[i]));
    }
    //中序遍历二叉排序树
    System.out.println("中序遍历二叉排序树~");
    binarySortTree.infixOrder(); // 1, 3, 5, 7, 9, 10, 12
    //测试一下删除叶子结点
    binarySortTree.delNode(12);
    binarySortTree.delNode(5);
    binarySortTree.delNode(10);
    binarySortTree.delNode(2);
    binarySortTree.delNode(3);

    binarySortTree.delNode(9);
    binarySortTree.delNode(1);
    binarySortTree.delNode(7);

    System.out.println("root=" + binarySortTree.getRoot());

    System.out.println("删除结点后");
    binarySortTree.infixOrder();
}
}

//创建二叉排序树
class BinarySortTree {
    private BSTnode root;
    public BSTnode getRoot() {
        return root;
    }

    //查找要删除的结点
    public BSTnode search(int value) {
        if(root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找父结点
    public BSTnode searchParent(int value) {
        if(root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    //编写方法:
    //1. 返回的 以node 为根结点的二叉排序树的最小结点的值
    //2. 删除node 为根结点的二叉排序树的最小结点
    /**
     *
     * @param BSTnode 传入的结点(当做二叉排序树的根结点)
     * @return 返回的 以node 为根结点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(BSTnode BSTnode) {
        BSTnode target = BSTnode;
        //循环的查找左子节点，就会找到最小值
        while(target.left != null) {
            target = target.left;
        }
        //这时 target就指向了最小结点
        //删除最小结点
        delNode(target.value);
        return target.value;
    }


    //删除结点
    public void delNode(int value) {
        if(root == null) {
            return;
        }else {
            //1.需求先去找到要删除的结点targetBSTnode
            BSTnode targetBSTnode = search(value);
            //如果没有找到要删除的结点
            if(targetBSTnode == null) {
                return;
            }
            //如果我们发现当前这颗二叉排序树只有一个结点
            if(root.left == null && root.right == null) {
                root = null;
                return;
            }

            //去找到targetNode的父结点
            BSTnode parent = searchParent(value);
            //如果要删除的结点是叶子结点
            if(targetBSTnode.left == null && targetBSTnode.right == null) {
                //判断targetNode 是父结点的左子结点，还是右子结点
                if(parent.left != null && parent.left.value == value) { //是左子结点
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {//是由子结点
                    parent.right = null;
                }
            } else if (targetBSTnode.left != null && targetBSTnode.right != null) { //删除有两颗子树的节点
                int minVal = delRightTreeMin(targetBSTnode.right);
                targetBSTnode.value = minVal;


            } else { // 删除只有一颗子树的结点
                //如果要删除的结点有左子结点
                if(targetBSTnode.left != null) {
                    if(parent != null) {
                        //如果 targetBSTnode 是 parent 的左子结点
                        if(parent.left.value == value) {
                            parent.left = targetBSTnode.left;
                        } else { //  targetBSTnode 是 parent 的右子结点
                            parent.right = targetBSTnode.left;
                        }
                    } else {
                        root = targetBSTnode.left;
                    }
                } else { //如果要删除的结点有右子结点
                    if(parent != null) {
                        //如果 targetBSTnode 是 parent 的左子结点
                        if(parent.left.value == value) {
                            parent.left = targetBSTnode.right;
                        } else { //如果 targetBSTnode 是 parent 的右子结点
                            parent.right = targetBSTnode.right;
                        }
                    } else {
                        root = targetBSTnode.right;
                    }
                }

            }

        }
    }

    //添加结点的方法
    public void add(BSTnode BSTnode) {
        if(root == null) {
            root = BSTnode;//如果root为空则直接让root指向node
        } else {
            root.add(BSTnode);
        }
    }
    //中序遍历
    public void infixOrder() {
        if(root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空，不能遍历");
        }
    }
}

//创建Node结点
class BSTnode {
    int value;
    BSTnode left;
    BSTnode right;
    public BSTnode(int value) {

        this.value = value;
    }


    //查找要删除的结点
    /**
     *
     * @param value 希望删除的结点的值
     * @return 如果找到返回该结点，否则返回null
     */
    public BSTnode search(int value) {
        if(value == this.value) { //找到就是该结点
            return this;
        } else if(value < this.value) {//如果查找的值小于当前结点，向左子树递归查找
            //如果左子结点为空
            if(this.left  == null) {
                return null;
            }
            return this.left.search(value);
        } else { //如果查找的值不小于当前结点，向右子树递归查找
            if(this.right == null) {
                return null;
            }
            return this.right.search(value);
        }

    }
    //查找要删除结点的父结点
    /**
     *
     * @param value 要找到的结点的值
     * @return 返回的是要删除的结点的父结点，如果没有就返回null
     */
    public BSTnode searchParent(int value) {
        //如果当前结点就是要删除的结点的父结点，就返回
        if((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //如果查找的值小于当前结点的值, 并且当前结点的左子结点不为空
            if(value < this.value && this.left != null) {
                return this.left.searchParent(value); //向左子树递归查找
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value); //向右子树递归查找
            } else {
                return null; // 没有找到父结点
            }
        }

    }

    @Override
    public String toString() {
        return "BSTnode [value=" + value + "]";
    }


    //添加结点的方法
    //递归的形式添加结点，注意需要满足二叉排序树的要求
    public void add(BSTnode BSTnode) {
        if(BSTnode == null) {
            return;
        }

        //判断传入的结点的值，和当前子树的根结点的值关系
        if(BSTnode.value < this.value) {
            //如果当前结点左子结点为null
            if(this.left == null) {
                this.left = BSTnode;
            } else {
                //递归的向左子树添加
                this.left.add(BSTnode);
            }
        } else { //添加的结点的值大于 当前结点的值
            if(this.right == null) {
                this.right = BSTnode;
            } else {
                //递归的向右子树添加
                this.right.add(BSTnode);
            }

        }
    }

    //中序遍历
    public void infixOrder() {
        if(this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null) {
            this.right.infixOrder();
        }
    }

}
