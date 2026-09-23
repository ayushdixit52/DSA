class Solution {
    public int networkDelayTime(int[][] times, int n, int src) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] t : times) {
            graph.get(t[0]).add(new int[]{t[1], t[2]});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        dist[src] = 0;
        pq.add(new int[]{0, src});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            int cost = curr[0];
            int node = curr[1];

            if(cost > dist[node]) {
                continue;
            }

            for(int[] e : graph.get(node)) {
                int nbr = e[0];
                int weight = e[1];

                if(cost + weight < dist[nbr]) {
                    dist[nbr] = cost + weight;
                    pq.add(new int[]{dist[nbr], nbr});
                }
            }
        }

        int max = 0;

        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            max = Math.max(max, dist[i]);
        }

        return max;
    }
}