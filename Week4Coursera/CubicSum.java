import java.util.Comparator;
import java.util.Scanner;

public class CubicSum {
    private static class Key implements Comparable<Key> {
        int value1,value2,sum;//sum to implement caching
        Key(int value1,int value2){
            this.value1=value1;
            this.value2=value2;
            this.sum = value1*value1*value1+value2*value2*value2;
        }

        @Override
        public String toString() {
            return this.value1+"^3 + " + this.value2 + "^3";
        }

        @Override
        public int compareTo(Key o) {
            if(this.sum!=o.sum)return this.sum>o.sum?1:-1;
            return 0;
        }

    }
    static  class Heap{
        int n=0;
        Key a[];
        Heap(int capacity){
            a=new Key[capacity+1];
        }
        void insert(Key k){
            a[++n]=k;
            swim(n);
        }
        void swim(int k){
            while(k>1&&less (k/2,k))
            {exch(k,k/2);k=k/2;}
        }
        boolean less(int x,int y){
            return a[x].compareTo(a[y])<0;
        }
        void exch(int k,int j){
            Key temp= a[k];
            a[k]=a[j];
            a[j]=temp;
        }
        private void sink(int k){
                while(2*k<=n){
                    int j=2*k;
                    if(less(j,j+1))j++;
                    if(!less(k,j))break;
                    exch(k,j);
                    k=j;
                }
        }
        private Key delMax(){
                exch(1,n);
                n--;
                sink(1);
                return a[n+1];

        }
        boolean isEmpty(){
            return n==0;
        }
    }
    public static void main(String[] args) {
        int a,b,c,d;
        System.out.println("Enter the value of n for Taxi numbers");
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        Heap h = new Heap(n*n);
        for (int i = 0; i <n ; i++) {
            for (int j = i+1; j <n ; j++) {
                Key sum=new Key(i,j);
                h.insert(sum);
            }
        }
        Key prev=h.delMax();
        while(!h.isEmpty()){
            Key curr=h.delMax();
            if(curr.sum==prev.sum){
                System.out.println(curr + " = " + prev );

            }
            prev=curr;
        }
    }
}
