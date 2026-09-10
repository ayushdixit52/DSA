class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>list=new ArrayList<>();
        char[][]chessboard=new char[n][n];
        for(int i=0;i<n;i++){
          for(int j=0;j<n;j++){
            chessboard[i][j]='.';
          }
        }
        nQueen(0,chessboard,list);
        return list;
    }
    public  void nQueen(int r,char[][]chessboard,List<List<String>>list){
        int n=chessboard.length;
        if(r==n){
            List<String>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new String(chessboard[i]));
             
        }
        list.add(ans);
        return;
        }
        for(int c=0;c<n;c++){
            if(isSafe(r,c,chessboard)){
            chessboard[r][c]='Q';
            nQueen(r+1,chessboard,list);
            chessboard[r][c]='.';
        }}
    }
    private boolean isSafe(int r,int c,char[][]chessboard){
        int n=chessboard.length;
        int i=r-1;
        while(i>=0){
            if(chessboard[i][c]=='Q') return false;
            i--;
        }
        i=r-1;
        int j=c-1;
        while(i>=0 && j>=0){
            if(chessboard[i][j]=='Q') return false;
            i--;
            j--;
        }
         i=r-1;
        j=c+1;
        while(i>=0 && j<n){
            if(chessboard[i][j]=='Q') return false;
            i--;
            j++;
        }
        return true;
        
    }
}
