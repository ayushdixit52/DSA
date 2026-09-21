class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for(int[] edge : pre) {
            int u = edge[0];
            int v = edge[1];
            graph.get(v).add(u);
            indegree[u]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0)
                q.offer(i);
        }

        int[] ans = new int[n];
        int idx = 0;

        while(!q.isEmpty()) {
            int ele = q.poll();
            ans[idx++] = ele;

            for(int nbr : graph.get(ele)) {
                indegree[nbr]--;

                if(indegree[nbr] == 0)
                    q.offer(nbr);
            }
        }

        return idx == n ? ans : new int[0];
    }
}