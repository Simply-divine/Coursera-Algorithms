package UnionFind;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {

    private WeightedQuickUnionUF uf, uf1;
    private int number;
    private boolean[] openSiteSituation;
    private int noOfOpenSites = 0;
    private int index;

    /**
     * @param n
     */
    public Percolation(int n) {
        number = n;
        if (n <= 0) throw new IllegalArgumentException();
        openSiteSituation = new boolean[n * n + 2];
        uf = new WeightedQuickUnionUF(n * n + 2);
        uf1 = new WeightedQuickUnionUF(n * n + 1);
    }

    private boolean isIndex(int row, int column) {
        if (row <= 0 || row > number) return false;
        else return column > 0 && column <= number;
    }

    private int getIndex(int row, int column) {
        return row * number + column - number;
    }

    public void open(int row, int column) {


        if (row <= 0 || row > number) throw new IllegalArgumentException();
        if (column <= 0 || column > number) throw new IllegalArgumentException();
        int i = getIndex(row, column);
        if (!openSiteSituation[i]) {
            openSiteSituation[i] = true;
            noOfOpenSites++;
        }
        if (row == 1) {
            index = getIndex(row, column);
            uf.union(0, index);
            uf1.union(0, index);

        }
        if (row == number) {
            index = getIndex(row, column);
            uf.union(0, index);
        }


        if (isIndex(row + 1, column)) {
            int j = getIndex(row + 1, column);
            if (openSiteSituation[j]) {
                uf.union(i, j);
                uf1.union(i, j);
            }
        }
        if (isIndex(row - 1, column)) {
            int k = getIndex(row - 1, column);
            if (openSiteSituation[k]) {
                uf.union(i, k);
                uf1.union(i, k);
            }
        }
        if (isIndex(row, column + 1)) {
            int k = getIndex(row, column + 1);
            if (openSiteSituation[k]) {
                uf.union(i, k);
                uf1.union(i, k);
            }
        }
        if (isIndex(row, column - 1)) {
            int k = getIndex(row, column - 1);
            if (openSiteSituation[k]) {
                uf.union(i, k);
                uf1.union(i, k);
            }
        }


    }

    public boolean isOpen(int row, int column) {
        if (row <= 0 || row > number) throw new IllegalArgumentException();
        else if (column <= 0 || column > number) throw new IllegalArgumentException();
        else {
            index = getIndex(row, column);
            return openSiteSituation[index];
        }
    }

    public boolean isFull(int row, int column) {
        if (row <= 0 || row > number) throw new IllegalArgumentException();
        if (column <= 0 || column > number) throw new IllegalArgumentException();
        index = getIndex(row, column);
        return uf1.find(index) == uf1.find(0);

    }

    public int numberOfOpenSites() {
        return noOfOpenSites;
    }

    public boolean percolates() {
        return uf.find(0) == uf.find(number * number + 1);

    }


}