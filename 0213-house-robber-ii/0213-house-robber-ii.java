class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
         int[]dp=new int[nums.length];
         int[]dp1=new int[nums.length];

        Arrays.fill(dp,-1);
        Arrays.fill(dp1,-1);

        return Math.max(solve(1,nums,dp),solve1(nums.length-2,nums,dp1));
    }
    public int solve(int i,int[]nums,int[]dp){
      if(i>=nums.length){
        return 0;
      }
      if(dp[i]!=-1){
        return dp[i];
      }
      int skip=solve(i+1,nums,dp);
      int rob=solve(i+2,nums,dp)+nums[i];
      dp[i]=Math.max(skip,rob);
      return dp[i];
}
public int solve1(int i,int[]nums,int[]dp1){
      if(i<0){
        return 0;
      }
      if(dp1[i]!=-1){
        return dp1[i];
      }
      int skip=solve1(i-1,nums,dp1);
      int rob=solve1(i-2,nums,dp1)+nums[i];
      dp1[i]=Math.max(skip,rob);
      return dp1[i];
}
}