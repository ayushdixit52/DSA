class Solution {
    public int deleteAndEarn(int[] nums) {
       int max=0;
       for(int x:nums){
        max=Math.max(max,x);
       } 
       int []sum=new int[max+1];
       for(int x:nums){
        sum[x]+=x;
       }
       int []dp= new int[max+1];
       Arrays.fill(dp,-1);
      
       return solve(max,sum,dp);
    }
    public int solve(int i,int[]sum,int[]dp){
      if(i<=0){
        return 0;
      }
      if(i==1){
        return sum[1];
      }
      if(dp[i]!=-1){
        return dp[i];
      }
      int skip=solve(i-1,sum,dp);
      int rob=solve(i-2,sum,dp)+sum[i];
      dp[i]=Math.max(skip,rob);
      return dp[i];
          }
}