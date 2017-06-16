package com.crackbook;

/**
 * Created by Amal on 5/9/2017.
 */

public class p_5_OneAway {
    public static void main(String[] args){
        boolean isTrue=isOneWay("pale","pale");
    }

    public static boolean isOneWay(String s1, String s2)
    {
        if(Math.abs(s1.length()-s2.length())>1)
            return false;
        int count=0;
        int index=0;
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)!=s2.charAt(index))
            {
                if(count>1)
                    return false;
                else
                {
                    count++;
                    if(s2.length()>s1.length())
                    {
                        i--;
                    }
                    else
                    if(s2.length()<s1.length())
                    {
                        index--;
                    }
                    index++;
                }
            }
        }
        if(count>0&& s1.length()-index>1)
            return false;
        return true;
    }
}
