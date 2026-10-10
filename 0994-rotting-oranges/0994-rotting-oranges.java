class Solution {
    public class Triplet{
        int row;
        int col;
        int time;
        Triplet(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
        
        Queue<Triplet>q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==2){
                    q.add(new Triplet(i,j,0));
                }
            }
        }
        int maxTime=0;
        while(!q.isEmpty()){
            Triplet front=q.poll();
            int row=front.row,col=front.col,time=front.time;
            maxTime=Math.max(maxTime,time);
            if(row-1>=0 && arr[row-1][col]==1){
                arr[row-1][col]=2;
                q.add(new Triplet(row-1,col,time+1));
            }
             if(row+1<m && arr[row+1][col]==1){
                arr[row+1][col]=2;
                q.add(new Triplet(row+1,col,time+1));
            }
             if(col-1>=0 && arr[row][col-1]==1){
                arr[row][col-1]=2;
                q.add(new Triplet(row,col-1,time+1));
            }
             if(col+1<n && arr[row][col+1]==1){
                arr[row][col+1]=2;
                q.add(new Triplet(row,col+1,time+1));
            }
            
        }
          for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                  return -1;
                }
            }
        }
        return maxTime;
    }
}