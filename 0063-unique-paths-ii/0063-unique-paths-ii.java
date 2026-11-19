class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;

        int[][]dp=new int[m][n];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return f(m-1,n-1,dp,arr);
    }
    private int f(int i,int j,int[][]dp,int[][]arr){
        if(i>=0 && j>=0 && arr[i][j]==1) return 0;
        if(i==0&& j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=f(i-1,j,dp,arr);
        int left=f(i,j-1,dp,arr);
        return dp[i][j]=left+up;

    }
}