class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int c=0;
        boolean []visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                c++;
                bfs(i,visited,isConnected);
            }
        }
        return c;
    }
    private void bfs(int i,boolean[]visited,int[][]isConnected){
        int n=isConnected.length;
        Queue<Integer> q=new LinkedList<>();
        q.offer(i);
        visited[i]=true;
        while(!q.isEmpty()){
            int front=q.poll();
            for(int j=0;j<n;j++){
                if(isConnected[front][j]==1 && !visited[j]){
                    q.offer(j);
                    visited[j]=true;
                }
            }
        }

    }
}