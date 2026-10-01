class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
      long need = (long) m * k;

        if (need > bloomDay.length)
            return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int x : bloomDay) {
            low = Math.min(low, x);
            high = Math.max(high, x);
        }

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int flowers = 0;
        int bouquets = 0;

        for (int x : bloomDay) {
            if (x <= day) {
                flowers++;

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }

            if (bouquets >= m)
                return true;
        }

        return false;   
    }
}