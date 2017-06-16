package com.science;
/**
 * Created by amal on 3/3/2017.
 */
public class Heap<E> {
    int lastPosition=0;
    E[] array;
    public Heap(int Size)
    {
        array=(E[]) new Object[Size];
    }

    //start array from index 1;
    //Complexity O(logn)
    public void Add(E obj)
    {
        array[++lastPosition]=obj;
        upHeap(lastPosition);
    }
    //Complexity O(logn)
    private void upHeap(int position) {
        if(position==0)
            return;
        int parent=(int) Math.floor((position)/2);
        if(((Comparable<E>)array[position]).compareTo(array[parent])>0) {
            Swap(position, parent);
            upHeap(parent);
        }
    }
    //Complexity O(logn)
    private void downHeap(int parent) {
        if(parent==0)
            return;
        int left=parent*2+1;
        int right=parent*2+2;
        if(left==lastPosition&&((Comparable<E>)array[left]).compareTo(array[parent])>0) {
            Swap(parent, left);
            return;
        }
        if(right==lastPosition&&((Comparable<E>)array[right]).compareTo(array[parent])>0) {
            Swap(parent, right);
            return;
        }
        if(left>lastPosition||right>lastPosition)
        {
            if(((Comparable<E>)array[left]).compareTo(array[right])>0&&(((Comparable<E>)array[left]).compareTo(array[parent])>0))
            {
                Swap(left,parent);
                downHeap(left);
            }
            else  if(((Comparable<E>)array[left]).compareTo(array[right])<0&&(((Comparable<E>)array[right]).compareTo(array[parent])>0))
            {
                Swap(right,parent);
                downHeap(right);
            }
        }
    }
    private void Swap(int from,int to)
    {
        E tmp=array[from];
        array[from]=array[to];
        array[to]=tmp;
    }

    //mainly replace max value heap root with last element in the heap and decrease lastindex
    // to exclude this item from downheap and repeat till whole array is sorted and last index=0
    //Complexity O(nlogn)
    public Object[] HeapSort()
    {
        if(lastPosition==0)
            return null;
        while (lastPosition>1) {
            Swap(1, lastPosition);
            lastPosition--;
            downHeap(1);
        }
        return array;
    }
}
