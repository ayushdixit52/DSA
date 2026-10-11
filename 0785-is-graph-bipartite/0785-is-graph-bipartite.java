class Solution {
    public boolean isBipartite(int[][] edges) {
       List<List<Integer>> graph=new ArrayList<>();
       int V=edges.length;
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < V; i++){
    for(int ele : edges[i]){
        graph.get(i).add(ele);
    }
}
      
        int []vis=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(!bfs(i,graph,vis)){
                    return false;
                }
            }
        }
        return true; 
    }
    private boolean bfs(int src,List<List<Integer>> graph,int []vis){
        vis[src]=1;
        Queue<Integer>q=new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int front=q.poll();
            int color=vis[front];
            for(int ele:graph.get(front)){
                if(vis[ele]==0){
                q.add(ele);
                vis[ele]=3-color;
                }
                else if(vis[ele]==color) return false;
            }
        }
        return true;
    }
}