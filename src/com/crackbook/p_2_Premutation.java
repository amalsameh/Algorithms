package com.crackbook;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Amal on 5/8/2017.
 */
public class p_2_Premutation {
    public static void main(String[] args) {

    }

    public static boolean checkPrem(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int result = 0;
        for (int i = 0; i < s1.length(); i++) {
            result += s1.charAt(i) ^ s2.charAt(i);
        }
        if (result > 0)
            return false;
        else
            return true;
    }

    public static boolean checkPerm2(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int[] chars = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i)] += 1;
        }
        for (int i = 0; i < s2.length(); i++) {
            chars[s2.charAt(i) - 'a'] -= 1;
            if (chars[s2.charAt(i)] < 0)
                return false;
        }
        return true;
    }
}
