class UnionFind{
    int[] parent;
    int components;

    public UnionFind(int n){
        parent = new int[n];
        components = n;
        for(int i=0;i<n;i++){
            parent[i] =i;
        }
    }

    private int find(int i){
        if(parent[i]==i){
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    private boolean union(int u, int v){
        int rootu = find(u);
        int rootv = find(v);

        if(rootu == rootv){
            return false;
        }
        parent[rootu]=rootv;
        components--;
        return true;
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1){
             return false;
        }
        UnionFind uf = new UnionFind(n);
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(!uf.union(u,v)){
                return false;
            }
        }
        return uf.components==1;
    }
}
