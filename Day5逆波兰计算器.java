//后缀表达式的计算器,计算机更加容易理解
//对于集合的理解,相比与数组,数组的增删操作很麻烦需要移动元素,而集合就提供了现成的方法add(),remove()等,而且不用设初值各种的好处,更灵活更方便
package com.shh;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day5逆波兰计算器 {
    public static void main(String[] args) {
            String s="3 4 + 5 x 6 -";
            //String []split=s1.split(" ");
            //System.out.println(split[0]);//只能看到数组其中一个的元素,需要循环遍历每个元素才能看到
            System.out.println(getSplit(s));//可以直接看到数组
            List ss=new ArrayList();
            ss=getSplit(s);
            int res1=count(ss);
            System.out.println("res="+res1);
    }
    public static List<String> getSplit(String s1)//省去<String>也是可以的,为了规范性而写
    {
        String []split=s1.split(" ");//以空格为分割切分字符串片段
        List<String>list =new ArrayList<String>();//也可以写成List list =new ArrayList(),表示随存储的元素而变,<>中的不能是其它类型
        //也可以写成ArrayList<String>list =new ArrayList<String>();List包含了ArrayList,在后续的使用上更加灵活
        for(String a:split)//集合增强for,相当于
        {
            list.add(a);//将数组split中的每个元素取出放到list中
        }
        return list;
    }
    public static int count(List<String> s2)
    {
        int num1;
        int num2;
        Stack<String> stack=new Stack<String>();
        for(String a:s2)
        {
           if(!(a.equals("+")||a.equals("-")||a.equals("x")||a.equals("/")))
           {
               stack.push(a);
           }
           else
           {
               int res=0;
               num1=Integer.parseInt(stack.pop());//将字符串类型转换为整型
               num2=Integer.parseInt(stack.pop());
               switch (a)
               {
                  case "+":res=num2+num1;stack.push(Integer.toString(res));break;
                  case "-":res=num2-num1;stack.push(Integer.toString(res));break;
                  case "x":res=num2*num1;stack.push(Integer.toString(res));break;
                  case "/":res=num2/num1;stack.push(Integer.toString(res));break;
                  default:break;
               }
           }

        }
        return Integer.parseInt(stack.pop());
    }
}
