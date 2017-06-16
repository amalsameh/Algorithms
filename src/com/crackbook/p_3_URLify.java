package com.crackbook;

/**
 * Created by Amal on 5/8/2017.
 */
public class p_3_URLify {
    public static void main(String[] args) {

    }
    public static int URLify(String s,int size)
    {
        int count=0;
        if(s.length()==0)
            return 0;
        else {
            char[] str = s.toCharArray();

            for (int i=size-1;i>=0;i--)
            {
                if(str[i]==' ')
                    count++;
            }
            int Index=size+count*2;
            for (int i=size-1;i>=0;i--)
            {
                if(str[i]==' ')
                {
                    str[Index-3]='%';
                    str[Index-2]='2';
                    str[Index-1]='0';
                    Index-=3;
                }
                else {
                    str[Index-1] = str[i];
                    Index--;
                }
            }
            return count;
        }

    }
}
