package com.science;
import java.util.Iterator;

/**
 * Created by amal on 3/2/2017.
 */
public class LinkedList<E> implements Iterable
{
    public static void main(String[] args) {
        LinkedList<String> myList=new LinkedList<String>();
        myList.AddFirst("First");
        myList.AddFirst("Second");
        myList.AddFirst("Third");
        myList.AddFirst("Fourth");
        myList.AddFirst("Fifth");
        myList.AddFirst("Six");
        myList.AddLast("Last");
        myList.Remove("Third");
        myList.removeFirst();
        myList.removeLast();
        int size=myList.currentSize;
    }
    @Override
    public Iterator iterator() {
        return new iteratorHelper();
    }

    //All operations we should check if it is Empty,Single Element, at Beginning, End,Middle
    class iteratorHelper implements Iterator<E>
    {
        Node<E> index;
        public iteratorHelper()
        {
            index = head;
        }

        @Override
        public E next() {
            if(!hasNext())
                return null;
            else
            {
                E val=index.data;
                index=index.next;
                return val;
            }
        }

        @Override
        public boolean hasNext() {
            if(index!=null)
                return true;
            return false;
        }
    }
    class Node<E>implements Comparable<E>
    {
        public E data;
        public Node<E> next;
        public Node(E obj)
        {
            data = obj;
            next = null;
        }
        @Override
        public int compareTo(E o) {
            return ((Comparable<E>)o).compareTo(this.data);
        }
    }
    private Node<E> head;
    private Node<E> tail;
    int currentSize;//make getting size with complexity O(1)
    public LinkedList()
    {
        head = null;
        tail = null;
        currentSize = 0;
    }

    public boolean isEmpty()
    {
        if(head==null||head==tail||currentSize==0)
            return true;
        else
            return false;
    }
    //public void AddFirst(E obj)//Complexity O(1)
    //{
    //    Node<E> node = new Node<E>(obj);
    //    node.next = head;
    //    head = node;
    //    currentSize++;
    //}

    public void AddFirst(E obj)//Complexity O(1) updating tail pointer
    {
        Node<E> node = new Node<E>(obj);
        node.next = head;
        if (head == null)
            head=tail = node;
        else
        head = node;
        currentSize++;
    }

    //public void AddLast(E obj) //Complexity O(n)
    //{
    //    Node<E> node = new Node<E>(obj);
    //    if (head == null)
    //    {
    //        head = node;
    //        currentSize++;
    //        return;
    //    }

    //    Node<E> tmp = head;
    //    while (tmp.next != null)
    //        tmp = tmp.next;
    //    tmp.next = node;
    //    node.next = null;
    //    currentSize++;
    //}
    public void AddLast(E obj) //Complexity O(1) using tail pointer
    {
        Node<E> node = new Node<E>(obj);
        if (head == null)
        {
            head=tail = node;
            currentSize++;
            return;
        }
        tail.next = node;
        tail = node;
        currentSize++;
    }
    public E removeFirst()
    {
        if (isEmpty())
            return null;
        E tmp = head.data;
        if(head==tail)
            head = tail = null;
        else
            head = head.next;
        currentSize--;
        return tmp;
    }
    public E removeLast()
    {
        if (isEmpty())
            return null;
        if (head == tail)
            return removeFirst();

        Node<E>previous = null;
        Node<E> current = head;
        while(current!=tail)
        {
            previous = current;
            current = current.next;
        }
        E tmp = current.data;
        previous.next = null;
        tail = previous;
        current = null;
        return tmp;
    }
    public E Remove(E obj)
    {
        Node<E> previous = null;
        Node<E> current = head;
        while (current != null)
        {

            if (((Comparable<E>)current.data).compareTo(obj)==0)
            {
                if (isEmpty())
                    return removeFirst();
                if (current == tail)
                    return removeLast();
                currentSize--;
                previous.next = current.next;
                current.next = null;
                return current.data;
            }
            else
            {
                previous = current;
                current = current.next;
            }
        }
        return null;
    }
    public boolean Find(E obj)
    {
        Node<E> current = head;
        while (current != null)
        {
            if (((Comparable<E>)current.data).compareTo(obj)==0)
            {
                return true;
            }
            else
            {
                current = current.next;
            }
        }
        return false;
    }
    public E PeekFirst()
    {
        if (head == null)
            return null;
        return head.data;
    }
    public E PeekLast()
    {
        if (tail == null)
            return null;
        return tail.data;
    }
}
