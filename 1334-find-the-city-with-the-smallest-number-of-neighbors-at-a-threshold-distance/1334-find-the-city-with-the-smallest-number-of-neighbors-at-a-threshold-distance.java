class Solution {
    class Edge {
        int v;
        int wt;

        public Edge(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    class PQNode {
        int u;
        int du;

        public PQNode(int u, int du) {
            this.u = u;
            this.du = du;
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            adj.get(u).add(new Edge(v, wt));
            adj.get(v).add(new Edge(u, wt));
        }

        int ans = -1;
        int minCount = Integer.MAX_VALUE;

        for (int src = 0; src < n; src++) {

            int[] d = new int[n];
            Arrays.fill(d, Integer.MAX_VALUE);

            d[src] = 0;

            PriorityQueue<PQNode> pq =
                new PriorityQueue<>((a, b) -> a.du - b.du);

            pq.add(new PQNode(src, 0));

            while (!pq.isEmpty()) {

                PQNode curr = pq.poll();

                int u = curr.u;
                int du = curr.du;

                if (du > d[u]) {
                    continue;
                }

                for (Edge edge : adj.get(u)) {

                    int v = edge.v;
                    int wt = edge.wt;

                    if (du + wt < d[v]) {

                        d[v] = du + wt;

                        pq.add(new PQNode(v, d[v]));
                    }
                }
            }

            int count = 0;

            for (int i = 0; i < n; i++) {
                if (i != src && d[i] <= distanceThreshold) {
                    count++;
                }
            }

            if (count <= minCount) {
                minCount = count;
                ans = src;
            }
        }

        return ans;
    }
}