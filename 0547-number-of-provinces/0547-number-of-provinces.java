class Solution {
    public int findCircleNum(int[][] isConnected) {
       int n=isConnected.length, c=0;
       boolean []visited=new boolean[n];
       for(int i=0;i<n;i++){
        if(!visited[i]){
            c++;
            dfs(i,isConnected,visited);
        }
       } 
       return c;
    }
    private void dfs(int curr,int[][]isConnected,boolean[]visited){
        visited[curr]=true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[curr][i]== 1 && !visited[i]) dfs(i,isConnected,visited);
        }
    
}}
