import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
    private static int partition(Comparable[] array,int low,int high){
        int i=low,j=high+1;
        while(true) {
            while (isLess(array[++i], array[low])) {
                if (i == high) break;
            }
            while (isLess(array[low], array[--j])) {
                if (j == low) break;
            }
            if(i>=j){
                break;
            }
            exchange(array,i,j);
        }
        exchange(array,low,j);
        return j;
    }
    public void sort(Comparable[] array){
        StdRandom.shuffle(array);
        sort(array,0,array.length-1);
    }

    private void sort(Comparable[] array, int low, int high) {
        if(high<=low)return;
        int j=partition(array,low,high);
        sort(array,low,j);
        sort(array,j+1,high);
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    private static boolean isLess(Comparable comparable, Comparable comparable1) {
        return comparable.compareTo(comparable1)<0;
    }
}
