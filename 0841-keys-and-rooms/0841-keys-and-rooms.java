class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[]visited=new boolean[n];
        visited[0]=true;
        Queue<Integer>q=new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty()){
            int front=q.poll();
            for(int nei:rooms.get(front)){
                if(!visited[nei]){
                    q.offer(nei);
                    visited[nei]=true;
                }
            }
        }
        for(boolean flag:visited){
            if(!flag) return false;
        }
        return true;
    }
}