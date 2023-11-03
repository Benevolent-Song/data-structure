//即实现波兰计算器转换为逆波兰计算器,使计算更加方便了
//不需要知道为什么这样做,只因为有这样一个简便的方法,只要知道处理的步骤就好
//使用两个栈,一个符号栈存放符号,一个中间结果存放栈
//一位一位地取中缀表达式的字符,遇到数字直接放到中间结果栈,遇到符号”(“直接放到字符栈,遇到”)“则pop出字符栈的符号,直到非”(“时
//对于加减乘除符号,与已经在符号栈的符号进行判断优先级,优先级小放入到中间结果栈,否则放入符号栈
//重复直到取完了所有的字符,此时再将符号栈的所有符号pop到中间结果栈
//中间栈存储的想要结果的反顺序
package com.shh;
import java.util.Stack;
public class Day5中缀表达式转换为后缀表达式 {
    public static void main(String[] args) {
        char a;
        String s="1+((2+3)×4)-5";
        Stack <String>stack1=new Stack<String>();//数字栈
        Stack <String>stack2=new Stack<String>();//符号栈
            for (int i=0;i<s.length();i++)
            {
                a=s.charAt(i);
                if (!(a=='+'||a=='-'||a=='*'||a=='/'))//数字则直接放入到数字栈中
                {
                    stack1.push(String.valueOf(a));//将char型转换成String型
                }
                else
                {
                    if (stack2 == null) //符号栈为空则直接放入
                    {
                        stack2.push(String.valueOf(a));
                    }
                    else//如果有符号了则再进行运算符的优先级的判断("("和”)“另外进行判断)
                    {
                        if (a == ')')
                        {
                            while (true)
                            {
                                if(stack2.pop()=="(")
                                {
                                    break;
                                }
                                stack1.push(stack2.pop());
                            }
                        }
                        else if( a == '(')
                        {
                            stack2.push(String.valueOf(a));
                        }
                        else if( a != '('||a != ')')
                        {
                            String b=stack2.pop();
                            stack2.push(b);
                            if(b=="(")
                            {
                                stack2.push(String.valueOf(a));
                            }
                            else
                            {
                               if(priority(a)>priority(Integer.valueOf(b)))
                               {stack2.push(String.valueOf(a));}//压入符号栈
                               else
                               {stack1.push(String.valueOf(a));}//压入数字栈
                            }
                        }
                    }
                }
            }
            for (int i=0;i<s.length();i++)
            {
              String ss= stack1.pop();
              System.out.printf(ss);
              System.out.println(" ");
            }
    }
    //返回运算符的优先级，优先级是程序员来确定, 优先级使用数字表示
    //数字越大，则优先级就越高.
    public static int priority(int oper)
    {
        if(oper == '*' || oper == '/'){
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1; // 假定目前的表达式只有 +, - , * , /
        }
    }
}
