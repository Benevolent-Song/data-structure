//利用树的结构对数组来排序,利用了顺序存储为数组的二叉树父节点和子节点的关系
//1) 第 n 个元素的左子节点为 2 * n + 1
//2) 第 n 个元素的右子节点为 2 * n + 2(左子树+1)
//3) 第 n 个元素的父节点为 (n-1) / 2
//4) 最下端的非叶子节点的索引array.length/2-1,最后索引到0
//大顶堆:所有的父节点都大于它们的子节点  小顶堆:所有的父节点都小于它们的子节点
//首先将最底层的父节点与它的子节点比较,子节点大,则将子节点放到父节点位置上
//遍历该树的所有节点,最后形成一个大顶堆,头节点放到最末尾的节点,对剩下的节点重复上述操作
//最后得到一个顺序结构排列的树,转化为数组则是升序排列的数组
package com.shh;
import java.util.Arrays;
public class Day13堆排序 {
    public static void main(String[] args) {
        int arr[] = { 4 , 6 , -1 , 8 , 5 , 9 , -11 , 17 , -99 };
        heapSort(arr);
        System.out.println("排序后=" + Arrays.toString(arr));
    }
     /**将一个数组(二叉树),以i为父节点的子树,调整成一个大顶堆,i=0时将整颗树形成大顶堆
     * 完成将以i对应的非叶子结点的树调整成大顶堆
     * @param array 要处理的数组
     * @param i 非叶子节点的索引
     * @param length 还剩下要处理的元素,是逐渐减少的
     */
    public static void adjust(int[] array, int i, int length)
    {
        int temp=array[i];//暂时存储第一个非叶子节点的值
        for(int k=i*2+1;k<length;k=k*2+1)//遍历左叶子节点,k+1可以得到右叶子节点
        {
            if(k<length-1&&array[k]<array[k+1])//右子节点大于左子节点
            {
                k++;//将指针指向右子树,使得指针k始终指向子树中较大的节点,下面只要比较array[k]和temp的大小就好了
            }
            if (array[k]>temp)//将该子树中较大的子节点与父节点交换
            {
                array[i] = array[k]; //把较大的值赋给当前结点
                i = k; //!!! i 指向 k,以产生了交换的节点为父节点,继续往更深处循环比较
            }
            else
            {
                break;//该节点已经满足了我们想要的大顶堆,不需要进行操作了
            }
        }
        //当 for 循环结束后，我们已经将以 i 为父结点的树的最大值，放在了最顶(局部)
        array[i] = temp;//将 temp 值放到调整后的位置
    }
    //堆排序的方法
    public static void heapSort(int arr[])
    {
        int temp = 0;
        System.out.println("堆排序");
         //确定非叶子节点的索引,形成大顶堆(大范围调整,无序——>大顶堆)
        for(int i = arr.length / 2 -1; i >=0; i--) {
            adjust(arr, i, arr.length);
        }
        for(int j = arr.length-1;j >0; j--) {
            //交换,将父节点交换到最后部的叶子节点上,此次需要调整的元素减少了
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjust(arr, 0, j);
            //再次调整为大顶堆(小范围调整,已经是比较接近的大顶堆了,次大的本来就在第二层了),父节点为最大的,准备再次放到尾部
            /*也可以写成这样,从最小非叶子开始调整,但是运算速度慢了
            for(int i = j / 2 -1; i >=0; i--) {
                adjust(arr, i, j);
             */
        }
    }
}
