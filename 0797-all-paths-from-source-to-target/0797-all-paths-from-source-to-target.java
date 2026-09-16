class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
         List<List<Integer>> res=new ArrayList<>();
         dfs(0,graph,new ArrayList<>(),res);
         return res;
    }
    private void dfs(int curr,int[][] graph,List<Integer>path,List<List<Integer>> res){
        path.add(curr);
        if(curr==graph.length-1){
            res.add(new ArrayList<>(path));
        }
        else{
            for(int nbr:graph[curr]){
                dfs(nbr,graph,path,res);
            }
        }
        path.remove(path.size()-1);
    }
}