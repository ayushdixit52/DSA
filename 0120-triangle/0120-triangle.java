class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][]dp=new int[n][n];
        boolean [][]vis=new boolean[n][n];
        return solve(0,0,dp,triangle,vis);
            
        
    }
    int solve(int i,int j ,int[][]dp,List<List<Integer>> a,boolean[][]vis){
        int n=a.size();
        if(i==n-1) return  a.get(n-1).get(j);
        if (vis[i][j]) return dp[i][j];
        int d=a.get(i).get(j)+solve(i+1,j,dp,a,vis);
        int dg=a.get(i).get(j)+solve(i+1,j+1,dp,a,vis);
        vis[i][j]=true;
        return dp[i][j]=Math.min(d,dg);
    }
}