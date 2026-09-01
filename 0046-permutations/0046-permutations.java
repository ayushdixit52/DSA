class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> r=new ArrayList<>();
        premu(nums,0,r);
        return r;
    }
    private void premu(int[] nums,int i,List<List<Integer>> r){
        if(i==nums.length){
            List<Integer> permuta=new ArrayList<>();
            for(int num:nums) permuta.add(num);
            r.add(permuta);
            return; 
        }
        for(int j=i;j<nums.length;j++){
            swap(i,nums,j);
            premu(nums,i+1,r);
            swap(i,nums,j);
        }
    }
    private  void swap(int i,int[]nums,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}