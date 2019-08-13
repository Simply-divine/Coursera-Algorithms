import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first, last;
    private int count = 0;


    public Deque() {
    }                           // construct an empty deque

    // return an iterator over items in order from front to end
    // unit testing (optional)
    public static void main(String[] args) {
      }

    public boolean isEmpty() {
        return count == 0;
    }                 // is the deque empty?

    public int size() {
        return count;
    }                        // return the number of items on the deque

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (count == 0) {
            first = new Node(null, null, item);
            last = first;
        } else {
            first = new Node(null, first, item);
            first.next.prev = first;
        }
        count++;
    }          // add the item to the front

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (count == 0) {
            last = new Node(null, null, item);
            first = last;
        } else {
           // Node oldLast = last;
            last = new Node(last, null, item);
            last.prev.next = last;
        }
        count++;
    }           // add the item to the end

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = first.item;
        first = first.next;
        first.prev=null;
        count--;
        if (isEmpty()) last = null;
        return item;
    }                // remove and return the item from the front

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = last.item;
        if (count == 1) {
            first = null;
            last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        count--;
        if (isEmpty()) first = null;
        return item;
    }                 // remove and return the item from the end

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class Node {
        Node prev;
        Node next;
        Item item;

        public Node(Node prev, Node next, Item item) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }

    }

    private class ListIterator implements Iterator<Item> {
        Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}

