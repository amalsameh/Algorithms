package com.science;
import Interfaces.HashI;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.Iterator;

/**
 * Created by amal on 3/2/2017.
 */
public class Hash<K,V> implements HashI<K,V>,Iterable {
    public static void main(String[] args) {
        Hash<Integer,Integer> myHashTable=new Hash<Integer, Integer>(5);
        myHashTable.Add(1,1);
        myHashTable.Add(2,2);
        myHashTable.Add(3,3);
        myHashTable.Add(4,4);
        myHashTable.Add(5,5);
        myHashTable.Add(6,6);
        myHashTable.Add(7,7);
        myHashTable.Remove(6,6);
    }
    int tableSize,numElements;
    double loadFactor;
    double maxLoadFactor;
    LinkedList<HashElement<K,V>>[] hashList;
    public Hash(int tableSize) {
        this.tableSize = tableSize;
        hashList = (LinkedList<HashElement<K, V>>[]) new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++)
            hashList[i] = new LinkedList<HashElement<K, V>>();
        numElements = 0;
        maxLoadFactor = 0.75;
    }
    public double getLoadFactor()
    {
        return ((double)numElements)/tableSize;
    }
    public boolean Add(K key,V value) {
        loadFactor=getLoadFactor();
        if (Double.compare(loadFactor , maxLoadFactor)>=0) //I have to resizeArray
            resizeArray(tableSize*2);
        HashElement<K,V> _element=new HashElement(key,value);
        int hashKey=getHashValue(key);
        hashList[hashKey].AddFirst(_element);
        numElements++;
        return true;
    }
    public boolean Remove(K key,V value) {
        HashElement<K,V> _element=new HashElement(key,value);
        int hashKey=getHashValue(key);
        hashList[hashKey].Remove(_element);
        numElements--;
        return true;
    }
    public V getValue(K key) {
        int hashValue = getHashValue(key);
        for (Object e : hashList[hashValue]) {
            if (((Comparable<K>)(((HashElement<K,V> )e).key)).compareTo(key)==0)
                return ((HashElement<K,V> )e).value;
        }
        return null;
    }
    private int getHashValue(K key) {
        int hashValue = key.hashCode();
        hashValue = hashValue & 0x7FFFFFFF;
        hashValue = hashValue % tableSize;
        return hashValue;
    }
    private void resizeArray(int newSize) {
        LinkedList<HashElement<K, V>>[] newHashList = (LinkedList<HashElement<K, V>>[]) new LinkedList[newSize];
        for (int i = 0; i < newSize; i++)
            newHashList[i] = new LinkedList<HashElement<K, V>>();
        for (Object key : this) {
            V val = getValue((K) key);
            HashElement<K, V> element = new HashElement<K, V>((K) key, val);
            int hashValue = getHashValue((K) key);
            newHashList[hashValue].AddFirst(element);
        }
        hashList = newHashList;
        tableSize = newSize;
    }
    @Override
    public Iterator iterator() {
        return new iteratorHelper<>();
    }

    class HashElement<K,V> implements Comparable<HashElement<K,V>> {
        K key;
        V value;

        public HashElement(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public int compareTo(HashElement<K, V> obj) {
            return ((Comparable<K>) this.key).compareTo(obj.key);
        }
    }
    class iteratorHelper<T> implements Iterator<T> {
        T[] keys;
        int Position;
        public iteratorHelper() {
            keys = (T[]) new Object[numElements];
            int j = 0;
            for (int i = 0; i < tableSize; i++) {
                LinkedList<HashElement<K, V>> list = hashList[i];
                for (Object e : list) {
                    keys[j] = (T) ((HashElement<K, V>)e).key;
                }
            }
            Position = 0;
        }

        @Override
        public boolean hasNext() {
            return (Position<numElements);
        }

        @Override
        public T next() {
            if(!hasNext())
                return null;
            return keys[Position++];
        }
    }
}
