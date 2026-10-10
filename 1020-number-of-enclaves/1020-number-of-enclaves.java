class Solution {
      public class Triplet{
        int row;
        int col;
       
        Triplet(int row,int col){
            this.row=row;
            this.col=col;
            
        }
    }
    public int numEnclaves(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;
        
        Queue<Triplet>q=new LinkedList<>();
        
        for(int i=0;i<m;i++){
            if(arr[i][0]==1){
                arr[i][0]=-1;
                q.add(new Triplet(i,0));
            }
            if(arr[i][n-1]==1){
                arr[i][n-1]=-1;
                q.add(new Triplet(i,n-1));
            }
        }
        for(int j=0;j<n;j++){
            if(arr[0][j]==1){
                arr[0][j]=-1;
                q.add(new Triplet(0,j));
            }
            if(arr[m-1][j]==1){
                arr[m-1][j]=-1;
                q.add(new Triplet(m-1,j));
            }
        }

        while(!q.isEmpty()){
            Triplet front=q.poll();
            int row=front.row,col=front.col;
            
            if(row-1>=0 && arr[row-1][col]==1){
                arr[row-1][col]=-1;
                q.add(new Triplet(row-1,col));
            }
             if(row+1<m && arr[row+1][col]==1){
                arr[row+1][col]=-1;
                q.add(new Triplet(row+1,col));
            }
             if(col-1>=0 && arr[row][col-1]==1){
                arr[row][col-1]=-1;
                q.add(new Triplet(row,col-1));
            }
             if(col+1<n && arr[row][col+1]==1){
                arr[row][col+1]=-1;
                q.add(new Triplet(row,col+1));
            }
            
        }
        int c=0;
          for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                  c++;
                }
            }
        }
        return c;
    }
}