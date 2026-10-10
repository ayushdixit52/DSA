class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
         return bfs(rooms);
    }

    private boolean bfs(List<List<Integer>> rooms) {
        boolean[] visitedRooms = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> firstRoom = rooms.get(0);
        for (int key : firstRoom) {
            queue.offer(key);
        }
        visitedRooms[0] = true;

        while (!queue.isEmpty()) {
            int currentKey = queue.poll();
            if (visitedRooms[currentKey]) {
                continue;
            }
            List<Integer> nextRoom = rooms.get(currentKey);
            for (int key : nextRoom) {
                if (!visitedRooms[key]) {
                    queue.offer(key);
                }
            }
            visitedRooms[currentKey] = true;
        }

        for (boolean value : visitedRooms) {
            if (!value) {
                return false;
            }
        }
        return true;
    }
}