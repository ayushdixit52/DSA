class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        Backtrack(list,new ArrayList<>(),nums,target,0);
        return list;
    }
    private void Backtrack(List<List<Integer>> list,List<Integer>tempList,int[]nums,int target,int start){
        if(target<0) return;
        else if(target==0) list.add(new ArrayList<>(tempList));
        else{
            for(int i=start;i<nums.length;i++){
                tempList.add(nums[i]);
                Backtrack(list,tempList,nums,target-nums[i],i);
                tempList.remove(tempList.size()-1);
                
            }
        }
    }
}