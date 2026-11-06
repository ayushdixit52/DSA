class Solution {
    public List<Integer> eventualSafeNodes(int[][] adj) {
        int n=adj.length;
        List<List<Integer>> graph=new LinkedList<>();
        int[]indegree=new int[n];
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
         for(int v:adj[i]){
            graph.get(v).add(i);
            indegree[i]++;
         }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        List<Integer>ans=new ArrayList<>();
    
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int nbr:graph.get(node)){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    q.add(nbr);
                }
            }
            

        }
        Collections.sort(ans);
        return ans;
    }
        
}