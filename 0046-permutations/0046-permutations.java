class Solution {
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer>a=new ArrayList<>();
        boolean[]check=new boolean[arr.length];
        permutation(arr,ans,check,a);
        return ans;
    }
    static void permutation(int[]arr,List<List<Integer>> ans,boolean[]check,List<Integer>a){
        int n=arr.length;
        if(a.size()==n){
            List<Integer>copy=new ArrayList<>(a);
            ans.add(copy);
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!check[i]){
                a.add(arr[i]);
                check[i]=true;
                permutation(arr,ans,check,a);
                a.remove(a.size()-1);
                check[i]=false;
            }
        }
    }
}