package com.crackbook;

/**
 * Created by Amal on 5/9/2017.
 */
public class p_6_Compression {
    public static void main(String[] args){

    }
    public static String Compress(String s)
    {
        if(s.length()<=2)
            return s;
        StringBuilder Compressed=new StringBuilder();
        int charCount=1;
        int count=1;
        char c=s.charAt(0);
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==c)
                charCount++;
            else
            {
                Compressed.append(c+charCount);
                c=s.charAt(i);
                charCount=1;
                count++;
            }
        }
        Compressed.append(c+charCount);
        return (s.length()<Compressed.toString().length()?s:Compressed.toString());
    }
}
