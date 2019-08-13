package UnionFind;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


public class PercolationStats {
    private double cons = 1.96;
    private double[] result;
    private int test;

    public PercolationStats(int n, int trials) {
        if (n <= 0) throw new IllegalArgumentException();
        if (trials <= 0) throw new IllegalArgumentException();
        test = trials;
        result = new double[trials];
        for (int k = 0; k < trials; k++) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                int i = StdRandom.uniform(1, n + 1);
                int j = StdRandom.uniform(1, n + 1);
                if (!p.isOpen(i, j))
                    p.open(i, j);

            }

            result[k] = (double) p.numberOfOpenSites() / (n * n);
        }
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        PercolationStats p = new PercolationStats(a, b);
        System.out.println("mean: " + p.mean());
        System.out.println("confidenceHi: " + p.confidenceHi());
        System.out.println("confidenceLo: " + p.confidenceLo());
    }

    public double mean() {
        return StdStats.mean(result);
    }

    public double stddev() {
        return StdStats.stddev(result);
    }

    public double confidenceLo() {
        return this.mean() - cons * this.stddev() / Math.sqrt(test);
    }

    public double confidenceHi() {
        return this.mean() + cons * this.stddev() / Math.sqrt(test);
    }
}
