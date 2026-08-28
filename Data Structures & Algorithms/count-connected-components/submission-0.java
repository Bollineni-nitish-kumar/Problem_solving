class UnionFind{
    int[] parent;
    int components;

    public UnionFind(int n){
        parent = new int[n];
        components = n;

        for(int i=0;i<n;i++){
            parent[i] = i;
        }
    }

    public int find(int i){
        if(parent[i]==i){
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    public void union(int u,int v){
        int rootU = find(u);
        int rootV = find(v);

        if(rootU == rootV){
           return;
        }
        parent[rootU] = rootV;
        components--;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int i=0;i<edges.length;i++){
            int u =edges[i][0];
            int v =edges[i][1];

            uf.union(u,v);
        }

        return uf.components;
    }
}
