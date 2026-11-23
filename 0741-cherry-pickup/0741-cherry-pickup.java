class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;

        int[][][] dp = new int[n][n][n];

        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MIN_VALUE);
            }
        }

        return Math.max(0, solve(0, 0, 0, grid, dp));
    }

    private int solve(int i, int j, int k, int[][] grid, int[][][] dp) {
        int n = grid.length;
        int l = i + j - k;

        if (i >= n || j >= n || k >= n || l >= n ||
            grid[i][j] == -1 || grid[k][l] == -1) {
            return -100000000;
        }

        if (i == n - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (dp[i][j][k] != Integer.MIN_VALUE) {
            return dp[i][j][k];
        }

        int val = grid[i][j];

        if (i != k || j != l) {
            val += grid[k][l];
        }

        int d = solve(i + 1, j, k + 1, grid, dp);
        int r = solve(i + 1, j, k, grid, dp);
        int u = solve(i, j + 1, k + 1, grid, dp);
        int v = solve(i, j + 1, k, grid, dp);

        return dp[i][j][k] = val + Math.max(Math.max(d, r), Math.max(u, v));
    }
}