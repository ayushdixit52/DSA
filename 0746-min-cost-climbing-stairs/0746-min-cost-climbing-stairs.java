class Solution {
    private int[]dp;
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        return Math.min(minCost(cost,n-1),minCost(cost,n-2));
    }
    private int minCost(int[]cost,int i){
        if(i<0) return 0;
        if(i==0||i==1) return cost[i];
        
        if(dp[i]!=-1)return dp[i];
        dp[i]=cost[i]+Math.min(minCost(cost,i-1),minCost(cost,i-2));
        return dp[i];
    }
}