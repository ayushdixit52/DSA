class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
          Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
               List<Integer> subset=new ArrayList<>();
               sub(nums,0,res,subset);
               
               return res; 
      }
            public void sub(int[]nums,int i,List<List<Integer>> res, List<Integer> subset){
               
                    res.add(new ArrayList<>(subset));
                    for(int j=i;j<nums.length;j++){
                        if(j>i && nums[j]==nums[j-1]){
                            continue;
                        }
                    
            
                subset.add(nums[j]);
                sub(nums,j+1,res,subset);
                subset.remove(subset.size()-1);
                    }
            
  
    }
}