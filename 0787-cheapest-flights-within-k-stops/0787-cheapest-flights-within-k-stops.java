class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>>graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
            
        }
        for(int []e:flights){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            graph.get(u).add(new int[]{v,w});
           
        }
        int []stops=new int[n];
        Arrays.fill(stops,Integer.MAX_VALUE);
 PriorityQueue<int[]> pq =
            new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        stops[src]=0;
        pq.add(new int[]{0,src,0});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int cost=curr[0];
            int node=curr[1];
            int s=curr[2];
            if(node==dst) return cost;
            if(s>k) continue;

            if(s>stops[node])continue;
            stops[node]=s;

            for(int []e:graph.get(node)){
                int nbr=e[0];
                int weight=e[1];
                if(s+1<stops[nbr]){
                   
                    pq.add(new int[]{cost+weight,nbr,s+1});
                }
            }
        }
        return -1;


    }
}