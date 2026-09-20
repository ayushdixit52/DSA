class Solution {
    public boolean canFinish(int n, int[][] pre) {
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
        int c=0;
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(q.size()!=0){
            int ele=q.poll();
            c++;
            for(int nbr:graph.get(ele)){
                indegree[nbr]-=1;
                if(indegree[nbr]==0){
                   q.offer(nbr);
                }
            }
        }
        return c==n;
    }
}