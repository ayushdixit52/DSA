class Solution {
    public int splitArray(int[] nums, int k) {
       int low=0;
       int high=0;
       for(int x:nums){
        low=Math.max(low,x);
        high+=x;
       } 
       int ans=-1;
       while(low<=high){
        int mid=low+(high-low)/2;
        if(canPossible(nums,k,mid)){
            ans=mid;
            high=mid-1;
        }
        else{
            low=mid+1;
        }
       }
       return ans;
    }
    private boolean canPossible(int[]nums,int k,int split){
        int number=1;
        int sum=0;
        for(int x:nums){
            if(sum+x<=split){
                sum+=x;
            }
            else{
                number++;
                sum=x;
            }
        }
        return number<=k;
    }
}