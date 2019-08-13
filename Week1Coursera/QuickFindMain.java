package UnionFind;

public class QuickFindMain {
    public static void main(String[] args) {
        int[] id;
        QuickFind quickfind=new QuickFind(10);
        System.out.println(quickfind.connected(1, 2));
        quickfind.union(3,4);
        id=quickfind.getId();
        for (int i = 0; i <id.length ; i++) {
            System.out.print(id[i]+" ");
        }
        System.out.println();
        quickfind.union(4,6);
        quickfind.union(6,8);
        id=quickfind.getId();
        for (int i = 0; i <id.length ; i++) {
            System.out.print(id[i]+" ");
        }
        System.out.println();
        System.out.println(quickfind.connected(3, 8));
    }
}
