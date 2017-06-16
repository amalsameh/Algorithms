package com.crackbook;

import java.util.HashSet;

/**
 * Created by Amal on 5/8/2017.
 */
public class p_1_IsUnique {

    public static void main(String[] args) {
        boolean unquiechar=isUniqueUsingBit("test");
    }
    public boolean isUnique(String s) {
        HashSet<Character> mystr = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if(mystr.contains(s.charAt(i)))
                    return false;
            else
                mystr.add(s.charAt(i));
        }
        return true;
    }

    public static boolean isUniqueUsingBit(String s) {
        int unique=0;
        for (int i = 0; i < s.length(); i++) {
            if((unique &(1<<i-'a')) > 0)
                return false;
            else
                unique |=(1<<i-'a');
        }
        return true;
    }
}
