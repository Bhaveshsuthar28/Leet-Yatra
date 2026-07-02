class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();
        int[][] d = new int[m][n];
        for (int[] r : d) Arrays.fill(r, Integer.MAX_VALUE);

        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        Deque<int[]> q = new ArrayDeque<>();

        d[0][0] = grid.get(0).get(0);
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int x = cur[0], y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                int w = grid.get(nx).get(ny);
                if (d[x][y] + w < d[nx][ny]) {
                    d[nx][ny] = d[x][y] + w;
                    if (w == 0) q.offerFirst(new int[]{nx, ny});
                    else q.offerLast(new int[]{nx, ny});
                }
            }
        }

        return d[m - 1][n - 1] < health;
    }
}