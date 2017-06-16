package com.science;

/**
 * Created by Amal on 5/18/2017.
 */
public class Queue
{
    int size = 0;
    int rear = 0, front = 0;
    int[] items = null;
    public Queue (int s) {
        size = s;
        items = new int[s];
    }
    public  int Size()
    {
        return size - (rear + front) % size;
    }
    public Boolean IsEmpty()
    {
        return (rear==front);
    }
    public Boolean IsFull()
    {
        if(Size()==size-1)
            return true;
        else
            return false;
    }
    public void Enqueue(int o)
    {
        if (IsFull())
            return;
        else
        {
            items[rear] = o;
            rear = rear + 1 % size;
        }
    }
    public int Dequeue(int o)
    {
        if (IsEmpty())
            return 0;
        else
        {
            front = front + 1%size;
            return items[front];
        }
    }
    public int Front()
    {
        if (IsEmpty())
            return 0;
        else
            return items[front];
    }

}
