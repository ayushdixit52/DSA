class Solution {
    public int minPathSum(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;

        int[][]dp=new int[m][n];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return f(m-1,n-1,dp,arr);
    }
    private int f(int i,int j,int[][]dp,int[][]arr){
        
        if(i==0&& j==0) return arr[0][0];
        if(i<0 || j<0) return Integer.MAX_VALUE;

        if(dp[i][j]!=-1) return dp[i][j];
        int up=Integer.MAX_VALUE;
        int left=Integer.MAX_VALUE;
        if(i>0)up=arr[i][j]+f(i-1,j,dp,arr);
        if(j>0)left=arr[i][j]+f(i,j-1,dp,arr);
        return dp[i][j]=Math.min(left,up);

    }
}