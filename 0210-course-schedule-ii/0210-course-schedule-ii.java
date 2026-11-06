class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> graph=new LinkedList<>();
        int[]indegree=new int[n];
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[]edge:pre){
            int u=edge[0];
            int v=edge[1];
            graph.get(v).add(u);
            indegree[u]+=1;
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
        if(ans.size()!=n){
            return new int[0];

        }
        int []result=new int[n];
        for(int i=0;i<n;i++){
            result[i]=ans.get(i);
        }
        return result;
    }
}