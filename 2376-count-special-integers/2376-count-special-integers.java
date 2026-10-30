class Solution {

    String s;
    int[][][][] dp;

    public int countSpecialNumbers(int n) {

        s = String.valueOf(n);

        dp = new int[s.length()][1024][2][2];

        for (int[][][] a : dp) {
            for (int[][] b : a) {
                for (int[] c : b) {
                    Arrays.fill(c, -1);
                }
            }
        }

        return dfs(0, 0, 1, 0);
    }

    int dfs(int idx, int mask, int tight, int started) {

        if (idx == s.length()) {
            return started == 1 ? 1 : 0;
        }

        if (dp[idx][mask][tight][started] != -1) {
            return dp[idx][mask][tight][started];
        }

        int limit = tight == 1 ? s.charAt(idx) - '0' : 9;

        int ans = 0;

        for (int d = 0; d <= limit; d++) {

            int newTight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {

                ans += dfs(idx + 1, mask, newTight, 0);

            } 
            else {

                if ((mask & (1 << d)) == 0) {

                    ans += dfs(
                        idx + 1,
                        mask | (1 << d),
                        newTight,
                        1
                    );
                }
            }
        }

        return dp[idx][mask][tight][started] = ans;
    }
}