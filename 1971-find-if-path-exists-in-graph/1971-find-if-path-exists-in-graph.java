class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int []edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return dfs(adj,source,destination,new boolean[n]);
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int curr,int dest,boolean []visited){
        if(curr==dest){
            return true;
        }
        visited[curr]=true;
        for(int nbr:adj.get(curr)){
            if(!visited[nbr]&& dfs(adj,nbr,dest,visited)) return true;
        }
        return false;
    }
}