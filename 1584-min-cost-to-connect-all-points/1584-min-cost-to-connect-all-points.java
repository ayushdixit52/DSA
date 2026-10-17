class Solution {
    int parent[];
    int rank[];
    int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    void Union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA==rootB){
            return;
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
     }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        parent=new int[n+1];
        rank=new int [n+1];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        int edges[][] = new int[n * (n - 1) / 2][3];
        int k = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(points[i][0] - points[j][0])
                         + Math.abs(points[i][1] - points[j][1]);

                edges[k][0] = i;
                edges[k][1] = j;
                edges[k][2] = cost;
                k++;
            }
        }

        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int totalCost = 0;
        int count = 0;

        for (int edge[] : edges) {
            if (find(edge[0]) != find(edge[1])) {
                Union(edge[0], edge[1]);
                totalCost += edge[2];
                count++;

                if (count == n - 1) {
                    break;
                }
            }
        }

        return totalCost;
        
        
        
    }
}