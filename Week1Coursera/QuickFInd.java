package UnionFind;

class QuickFind{
    public int[] getId() {
        return id;
    }

    private int[] id;
    private int pid,qid;
    QuickFind(int n){
        id=new int[n];
        for (int i = 0; i <n ; i++) {
            id[i]=i;
        }
    }
    boolean connected(int p,int q){
        boolean b = (id[p] == id[q]);
        return b;
    }
    public void union(int p,int q){
        pid=id[p];
        qid=id[q];
        for (int i = 0; i <id.length ; i++) {
            if(id[i]==pid){
                id[i]=qid;
            }
        }
    }
}
