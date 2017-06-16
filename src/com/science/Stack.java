package com.science;

/**
 * Created by Amal on 5/18/2017.
 */
 class StackNode
{
    int data = 0;
    int min = -1;
    public StackNode(int d,int m)
    {
        data = d;
        min = m;
    }
    public int getData()
    {
        return data;
    }
    public int getMin()
    {
        return min;
    }
}
    public class Stack
{
    int size = 0;
    StackNode[] items = null;
    int top = 0;
    int min = -1;
    public Stack (int s)
    {
        size = s;
        items = new StackNode[size];
    }
    public Boolean IsFull()
    {
        return (top == size - 1);
    }
    public Boolean IsEmpty()
    {
        return (top == 0);
    }
    public void Push(int o)
    {
        if (IsFull())
            return;
        else
        {
            if (min==-1||min > o)
                min = o;
            StackNode S = new StackNode(o, min); ;
            items[top] = S;
            top++;
        }
    }

    public void Minimum()
    {
        min=items[top - 1].getMin();
    }
    public int Pop()
    {
        if (IsEmpty ())
            return 0;
        else
        {
            top--;
            Minimum();
            return items[top].getData();
        }
    }
    public int peek()
    {
        if (IsEmpty())
            return 0;
        return items[top].getData();
    }
}
