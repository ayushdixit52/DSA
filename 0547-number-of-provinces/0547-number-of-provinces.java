class Solution {
    int parent[];
    int rank[];
    int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    void Union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return;

        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        int provinces=n;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
               if(isConnected[i][j]==1){
                if(find(i)!=find(j)){
                    Union(i,j);
                    provinces--;
                }
               } 
            }
            
        }
        return provinces;
    }
}