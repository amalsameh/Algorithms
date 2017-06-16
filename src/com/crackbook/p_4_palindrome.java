package com.crackbook;

import java.util.HashMap;

/**
 * Created by Amal on 5/8/2017.
 */
public class p_4_palindrome {
    public static void main(String[] args) {
        boolean isPlain = isPalindrome("asdrdsa");
    }

    public static boolean isPalindrome(String s)
    {
        if(s.length()<=1)return false;
        else
        {
            HashMap<Character,Integer> dict=new HashMap<Character, Integer>();
            for(int i=0;i<s.length();i++)
            {
                if(dict.containsKey(s.charAt(i))) {
                    int val = dict.get(s.charAt(i));
                    dict.put(s.charAt(i), val + 1);
                }
                else
                {
                    dict.put(s.charAt(i), 1);
                }
            }
            int oddcount=0;
            for(int i=0;i<s.length();i++)
            {
                int val = dict.get(s.charAt(i));
                if(val%2>0) {
                    if (oddcount > 0)
                        return false;
                    oddcount++;
                }
            }
            return true;
        }
    }
}
