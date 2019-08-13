package Week4Coursera;

import java.util.Iterator;

public class BinarySearchTree<Key extends Comparable<Key>,Value> implements Iterable<Key>{
    private Node root;


    private class Node{
        private Key key;
        private Value val;
        Node left,right;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }

    }
    public void put(Key key,Value value){
            root= put(root,key,value);
            //node returned
    }
    private  Node put(Node x,Key key,Value val){
            if(x==null){
                return new Node(key,val);
            }
            int cmp= key.compareTo(x.key);
            if(cmp<0){
                x.left=put(x.left,key,val);
            }
            else if(cmp>0){
                x.right=put(x.right,key,val);
            }
            else x.val=val;
            return x;
    }

    public Value get(Key key){
        Node x=root;
        while(x !=null){
            int cmp=key.compareTo(x.key);
            if(cmp<0){
                x=x.left;
            }
            else if(cmp>0){
                x = x.right;
            }
            else return x.val;
        }
        return null;
    }
    public Key floor(Key key){
        Node x=floor(root,key);
        if(x==null){
            return null;
        }
        return x.key;
    }

    @Override
    public Iterator<Key> iterator() {
        return null;
    }
    private Node floor(Node x, Key key) {
        if(x==null){
            return null;
        }
        int cmp=key.compareTo(x.key);
        if(cmp<0){
            return x;
        }
        if(cmp==0)return x;
        Node tmp= floor(x.right,key);
        if(tmp==null)return x;
        else return tmp;
    }
    public Key ceiling(Key key){
        Node x= ceiling(root,key);
        if(x==null)return null;
        return x.key;
    }

    private Node ceiling(Node root, Key key) {

    }

    public void delete(Key key){
        put(key,null);

    }

    public static void main(String[] args) {

    }
}
