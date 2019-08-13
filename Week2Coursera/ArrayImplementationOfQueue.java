package Week2Coursera;//import org.omg.CORBA.Object;

import java.util.Iterator;

public class ArrayImplementationOfQueue<Item> implements Iterable<Item> {
    private Item[] s;
    private int head,tail;
    public ArrayImplementationOfQueue(){
    s=(Item[]) new Object[1];
    }
    public void push(Item item){
        if(tail==s.length){resize(2*s.length);}
        s[tail++]=item;
    }
    public Item pop(){
        return s[head++];
    }
    private void resize(int capacity){
        Item[] copy=(Item[]) new Object[capacity];
        for (int i = 0; i <s.length ; i++) {
            copy[i]=s[i];
        }
        s=copy;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            return null;
        }
    }

}
