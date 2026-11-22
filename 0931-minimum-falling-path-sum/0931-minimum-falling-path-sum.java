class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][]dp=new int[m][n];
       boolean[][]vis=new boolean[m][n];
        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, f(m - 1, j, dp, matrix,vis));
        }

        return ans;
    }
    int f(int i,int j,int[][]dp,int[][]a,boolean[][]vis){
        int m=a.length;
        int n=a[0].length;
        if(j<0||j>=n) return (int) 1e9;
        if(i==0) return a[0][j];
        if(vis[i][j]) return dp[i][j];
        int s=a[i][j]+f(i-1,j,dp,a,vis);
        int ld=a[i][j]+f(i-1,j-1,dp,a,vis);
        int rd=a[i][j]+f(i-1,j+1,dp,a,vis);
        vis[i][j]=true;
        return dp[i][j]=Math.min(s,Math.min(ld,rd));
        
    }
}