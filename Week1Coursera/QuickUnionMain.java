package UnionFind;

import UnionFind.QuickUnion;

import java.io.Serializable;

public class QuickUnionMain implements Serializable {
    static final long serialVersionUID = -4087856301794920799L;
    public static void main(String[] args) {
        QuickUnion quickUnion=new QuickUnion(10);
        System.out.println(quickUnion.connected(2, 3));
        quickUnion.union(2,3);
        quickUnion.union(3,5);
        quickUnion.union(5,2);
        System.out.println(quickUnion.connected(2, 5));
       // System.out.println(Integer.valueOf(null));
    }
}
