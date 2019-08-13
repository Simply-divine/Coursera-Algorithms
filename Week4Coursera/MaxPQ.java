package Week4Coursera;

import java.util.Arrays;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N=0;
    MaxPQ(){
        pq=(Key[])new Comparable[1];
    }
    private void resize(int len){
        Key[] pqcopy = (Key[])new Comparable[len];
        for (int i = 1; i <=N ; i++) {
            pqcopy[i]=pq[i];
        }
        pq=pqcopy;
    }
    boolean isEmpty(){
        return N==0;
    }
    void insert(Key v){
        if(N==pq.length-1)resize(2*pq.length);
        pq[++N]=v;
        swim(N);
    }
    Key delMax(){
        Key max=pq[1];
        exch(1,N);
        pq[N--]=null;
        if(N>0 && N==pq.length/4)resize(pq.length/2);
        sink(1);
        return max;
    }
    public void swim(int k){
        while(k>1 && less(k/2,k)){
            exch(k,k/2);
            k=k/2;
        }
    }

    private void exch(int i, int j) {
        Key temp =pq[i];
        pq[i]=pq[j];
        pq[j]=temp;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j])<0;
    }

    public void printString() {
        for (int i = 1; i <=N ; i++) {
            System.out.println(pq[i]);
        }
    }

    private void sink(int k){
        while(2*k<=N){
            int j= 2*k;
            if(2*k<N&&less(j,j+1))j++;
            if(!less(k,j))break;
            exch(k,j);
            k=j;
        }
    }

}

