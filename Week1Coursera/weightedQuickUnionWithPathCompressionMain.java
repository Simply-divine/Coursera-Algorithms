package UnionFind;

public class weightedQuickUnionWithPathCompressionMain {
    public static void main(String[] args) {
        Wqupc wqupc=new Wqupc(10);
        wqupc.union(1,2);
        wqupc.union(6,9);
        wqupc.union(1,6);
        //System.out.println(wqupc.find(1));
        System.out.println(wqupc.connected(1, 2));
    }
}
