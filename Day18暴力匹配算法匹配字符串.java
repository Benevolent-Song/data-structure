//在字符串1中找到包含字符串2,并返回在字符串1中的位置
package com.shh;
import java.util.ArrayList;

public class Day18暴力匹配算法匹配字符串 {
    public static void main(String[] args) {
     String s1="硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
     String s2="尚硅谷你尚硅你";
     ArrayList temp=new ArrayList();
     int m=0;//判断s2字符的位置
        for(int i=0;i<s1.length()-1;i++)
        {
            if(s1.charAt(i)!=s2.charAt(m)&&m>1)
            {
                i = i - (m - 1);//暴力匹配的关键
                temp.clear();
                m=0;
            }
            if(s1.charAt(i)==s2.charAt(m))//判断的字符是相等
            {
                temp.add(s1.charAt(i));
                m++;//准备判断下一个字符
                if(m==s2.length())//如果找到了完整的字符串
                {
                    System.out.println(temp);
                    System.out.println("结束查找");
                    break;
                }
            }
        }
    }
}
