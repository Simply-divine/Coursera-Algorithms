package UnionFind;

import edu.princeton.cs.algs4.*;



public class UFNew {
    private int[] Parent;
    private int[] rank;
    int count;

    UFNew(int N) {
        if (N < 0) throw new IllegalArgumentException();
        count = N;
        Parent = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++) {
            Parent[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int p) {
        Validate(p);
        while (Parent[p] != p) {
            Parent[p] = Parent[Parent[p]];
            p = Parent[p];
        }
        return p;
    }

    private void Validate(int p) {
        if (p < 0 || p >= Parent.length)
            throw new IllegalArgumentException("p is not between 0 to " + (Parent.length - 1));
    }

    public Boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootp = Parent[p];
        int rootq = Parent[q];
        if (rootp == rootq) return;
        if (rank[p] > rank[q]) {
            Parent[rootq] = rootp;
            rank[p] += rank[q];
            count--;
        } else {
            Parent[rootp] = rootq;
            rank[q] += rank[q];
            count--;
        }
    }

    public static void main(String[] args) {

        int n = StdIn.readInt();
        UFNew uf = new UFNew(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count+" components");

    }
}