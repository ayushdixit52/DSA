class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }

        if(count_fresh == 0) return 0;
        int minutes=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            minutes++;
        
        for(int i=0;i<size;i++){
            int[]current=queue.poll();
            int r=current[0];
            int c=current[1];
        
        if(r-1>=0 && grid[r-1][c]==1){
            grid[r-1][c]=2;
            count_fresh--;
            queue.offer(new int[]{r-1,c});
        }
        if(r+1<m && grid[r+1][c]==1){
            grid[r+1][c]=2;
            count_fresh--;
            queue.offer(new int[]{r+1,c});
        }
        if(c-1>=0 && grid[r][c-1]==1){
            grid[r][c-1]=2;
            count_fresh--;
            queue.offer(new int[]{r,c-1});
        }
        if(c+1<n && grid[r][c+1]==1){
            grid[r][c+1]=2;
            count_fresh--;
            queue.offer(new int[]{r,c+1});
        }
        }}
        return count_fresh==0?minutes-1:-1;
        
    }
}