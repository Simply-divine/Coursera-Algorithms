package UnionFind;

public class Wqupc {
    private int[] id;
    private int[] sz;
    private int[] max;
    Wqupc(int n){
        id=new int[n];
        sz=new int[n];
        max=new int[n];
        for (int i = 0; i <n ; i++) {
            id[i]=i;
            sz[i]=1;
            max[i]=i;
        }
    }
    private int root(int i){
        while(id[i]!=i){
            id[i]=id[id[i]];
            i=id[i];
        }
        return i;
    }
    boolean connected(int p,int q) {
        return root(p) == root(q);
    }
    void remove(int i){
        for (int j = 0; j <id.length ; j++) {
            int p=root(j);
            if(p==i&&j!=i) {
                 id[j]=id[i];
            }
        }

    }

    public void union(int p,int q){
        int i=root(p);
        int j=root(q);
        if(i==j)return;
        if(sz[i]<sz[j]){
            id[i]=j;
            sz[j]+=sz[i];
        }
        else{

            id[j]=i;
            sz[i]+=sz[j];
        }
    }
}
