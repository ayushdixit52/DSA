class Solution {
    public int findCheapestPrice(int n, int[][] edges, int src, int dest, int k) {
     int[]visited=new int[n];
     Arrays.fill(visited,Integer.MAX_VALUE);
     visited[src]=0;
     for(int i=0;i<=k;i++){
        int[]temp=visited.clone();
        for(int []e:edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            if(visited[u]!=Integer.MAX_VALUE && visited[u]+w<temp[v]){
                temp[v]=visited[u]+w;

            }
           
        }
        visited=temp;
     }  
     return visited[dest]==Integer.MAX_VALUE?-1:visited[dest]; 
    }
}