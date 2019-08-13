package Week3Coursera;

import edu.princeton.cs.algs4.StdIn;

public class BottomUpMergeSort {
    private static void merge(Comparable[] a,Comparable[] aux,int lo,int mid,int hi ){
        for (int i = lo; i <=hi ; i++) {
            aux[i]=a[i];
        }
        int i=lo,j=mid+1;
        for (int k = lo; k <=hi ; k++) {
            if(i>mid)a[k]=aux[j++];
            else if(j>hi)a[k]=aux[i++];
            else if(less(a[j],a[i])) a[k]=aux[j++];
            else a[k]=aux[i++];
        }
    }
    public static void sort(Comparable[] a,Comparable[] aux,int lo,int hi ){

    }
    public static void sort(Comparable[] a){
        int N=a.length;
        Comparable[] aux=new Comparable[N];
        for (int sz = 1; sz <N ; sz=sz+sz) {
            for (int lo = 0; lo <N-sz ; lo+=sz+sz) {
                merge(a,aux,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
            }
        }
    }
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    public static void main(String[] args) {
        String s[]= StdIn.readAllStrings();
        sort(s);
        for (int i = 0; i <s.length ; i++) {
            System.out.println(s[i]+" ");;
        }
    }
}
