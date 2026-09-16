class Solution {
    public void sortColors(int[] arr) {
      int left=0;
      int i=0;
      int right=arr.length-1;
      while(i<=right){
        if(arr[i]==0){
            int temp=arr[i];
            arr[i]=arr[left];
            arr[left]=temp;
            left++;
            i++;
        }
        else if(arr[i]==2){
            int temp=arr[i];
            arr[i]=arr[right];
            arr[right]=temp;
            right--;
        }
        else{
            i++;
        }
      }
    }
}