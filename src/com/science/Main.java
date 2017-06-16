package com.science;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String> getPerm(String s)
    {
        List<String> myperm=new ArrayList<String>();
        perm("",s,myperm);
        return myperm;
    }
    private static void perm(String prefix, String s,List<String> permlist)
    {
        if(s.equals(""))
        {
            permlist.add(prefix);
            return ;
        }
        else
        {
            int n=s.length();
            for(int i=0;i<n;i++)
            {
                perm(prefix+s.charAt(i),s.substring(0, i)+s.substring(i+1,n),permlist);
            }
        }
    }

    private Boolean isPrime(int n)
    {
        if(n<2)return false;
        if(n==2)return true;
        if(n%2==0)return false;
        for(int i=3;i*i<=n;i+=2)
            if(n%i==0)
                return false;
        return true;
    }

    public static void main(String[] args) {

        //Heap
        Heap myHeap=new Heap(10);
        myHeap.Add(20);
        myHeap.Add(16);
        myHeap.Add(32);
        myHeap.Add(3);
        myHeap.Add(9);
        myHeap.Add(42);
        myHeap.Add(5);
        myHeap.Add(50);
        myHeap.Add(1);
        Object[] myarray=myHeap.HeapSort();
        Object[]  test=myHeap.array;
       List<String> permlist=new ArrayList<String>();
        permlist=getPerm("abc");
        System.out.print(permlist);
    }
}
