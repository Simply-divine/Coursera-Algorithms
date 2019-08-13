import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] s;
    private int size = 0;
    private int index;

    public RandomizedQueue() {
        s = (Item[]) new Object[1];
    }                 // construct an empty randomized queue

    public static void main(String[] args) {
        RandomizedQueue<Integer> r = new RandomizedQueue<>();
        System.out.println(r.isEmpty());
        r.enqueue(3);
        r.enqueue(4);
        r.enqueue(5);
        System.out.println(r.dequeue());
        Iterator<Integer> i = r.iterator();
        System.out.println(i.next());
        System.out.println(i.next());
        System.out.println(i.hasNext());
    }   // unit testing (optional)

    public boolean isEmpty() {
        return size == 0;
    }                 // is the randomized queue empty?

    public int size() {
        return size;
    }                        // return the number of items on the randomized queue

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (size == s.length) {
            resize(2 * s.length);
        }
        s[size++] = item;
    }           // add the item

    private void resize(int capacity) {
        Item[] ArrayCopy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            ArrayCopy[i] = s[i];
        }
        s = ArrayCopy;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (size == s.length / 4) {
            resize(s.length / 2);
        }
        index = StdRandom.uniform(size);
        Item item = s[index];
        s[index] = s[--size];
        s[size] = null;
        return item;
    }                    // remove and return a random item

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        index = StdRandom.uniform(size);
        return s[index];
    }                     // return a random item (but do not remove it)

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }// return an independent iterator over items in random order

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int[] indices;
        private int m=0;

        RandomizedQueueIterator() {
            indices=new int[size];

            for (int i = 0; i <size ; i++) {
                indices[i]=i;
            }
            for (int i = 0; i <size ; i++) {
                int toSwap=StdRandom.uniform(i+1);
                int temp=indices[toSwap];
                indices[toSwap]=indices[i];
                indices[i]=temp;
            }

        }

        @Override
        public boolean hasNext() {
            return (m < size);
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
//            index = StdRandom.uniform(indexcopy);
//            Item item = ArrayCopy[index];
//            ArrayCopy[index] = ArrayCopy[--indexcopy];
//            ArrayCopy[indexcopy] = null;
            return s[indices[m++]];
        }
    }
}

