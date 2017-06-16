/**
 * Created by amal on 3/5/2017.
 */
public class AVLTree<E> {
    int currentSize=0;
    Node<E> root;
    public AVLTree()
    {
    }
    public void Add(E obj)
    {
        Node<E> node=new Node<E>(obj);
        if(root==null) {
            root = node;
            return;
        }
        else
        Add(node,root);
        currentSize++;
        return;
    }
    public void Add(Node<E> newN,Node<E> parent) {
             if(((Comparable<E>)newN.data).compareTo(parent.data)>0) {
            if(parent.right==null) {
                parent.right = newN;
                newN.parent=parent;
                return;
            }
            else
                 Add(newN,parent.right);
        }
        else {
            if(parent.left==null) {
                parent.left=newN;
                newN.parent=parent;
                return;
            }
            else
                Add(newN,parent.left);
        }
        checkBalance(newN);
    }

    private void checkBalance(Node<E> node) {
        if(Math.abs(Height(node.left)-Height(node.right))>1)
            rebalancetree();
    }
    private int Height(Node<E> node) {
        return 0;
    }
    private void rebalancetree() {
    }

    class Node<E>
    {
        E data;
        Node<E> left;
        Node<E> right;
        Node<E> parent;
        public Node(E obj)
        {
            data=obj;
            left=right=parent=null;
        }
    }
}
