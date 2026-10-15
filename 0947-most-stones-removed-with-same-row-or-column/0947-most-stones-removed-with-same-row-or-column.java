class Solution {
    int parent[];
        int rank[];
        int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }
        boolean Union(int a,int b){
          int rootA=find(a);
          int rootB=find(b);
          if(rootA==rootB){
              return false;
          }
          if(rank[rootA]>rank[rootB]){
              parent[rootB]=rootA;
          }
          else if(rank[rootA]<rank[rootB]){
              parent[rootA]=rootB;
          }
          else{
              parent[rootB]=rootA;
              rank[rootA]++;
          }
          return true;
        }
    public int removeStones(int[][] stones) {
        int n=stones.length;
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1]){
                    Union(i,j);
                }
            }
        }
        int comp=0;
        for(int i=0;i<n;i++){
            if(find(i)==i){
                comp++;
            }
        }
        return n-comp;
    }
}