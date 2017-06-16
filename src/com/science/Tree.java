/**
 * Created by amal on 3/3/2017.
 */
//PreOrder Root-Left-Right
//InOrder Left-Root-Right
//PostOrder Left-Right-Root
public class Tree<E> {
Node<E> root;
int currentSize=0;
    class Node<E>
    {
        E data;
        Node<E> left;
        Node<E> right;
        public Node(E obj)
        {
            data=obj;
            left=right=null;
        }
    }
    public void Add(E obj)
    {
        if(root==null)
            root=new Node<E>(obj);
        else
            Add(obj,root);
        currentSize++;
    }
    public void Add(E obj,Node<E> node)
    {
        if(((Comparable<E>)obj).compareTo(node.data)>0)
        {
            if(node.right==null) {
                node.right = new Node<E>(obj);
                return;
            }
            else
                Add(obj,node.right);
        }
        else {
            if(node.left==null)
                node.left=new Node<E> (obj);
            else
                Add(obj,node.left);
        }
    }
    public boolean Contains(E obj)
    {
        return Contains(obj, this.root);
    }
    public boolean Contains(E obj, Node<E> node)
    {
        if(node==null)
            return false;
        else  if(((Comparable<E>)obj).compareTo(node.data)==0)
            return true;
        else if(((Comparable<E>)obj).compareTo(node.data)>0)
            return Contains(obj,node.right);
        else
            return Contains(obj,node.left);
    }
    public E Remove(E obj)
    {
        return Remove(obj,root);
    }

    public E Remove(E obj,Node<E> node)
    {
        return null;
    }

    public Node<E> rightRotate(Node<E> node)
    {
        Node<E> temp=node.left;
        node.left=temp.right;
        temp.right=node;
        return temp;
    }
    public Node<E> leftRotate(Node<E> node)
    {
        Node<E> temp=node.right;
        node.right=temp.left;
        temp.left=node;
        return temp;
    }
    public Node<E> rightLeftRotate(Node<E> node)
    {
        node.right=rightRotate(node.right);
        return leftRotate(node);
    }
    public Node<E> leftRightRotate(Node<E> node)
    {
        node.left=leftRotate(node.left);
        return rightRotate(node);
    }
}
