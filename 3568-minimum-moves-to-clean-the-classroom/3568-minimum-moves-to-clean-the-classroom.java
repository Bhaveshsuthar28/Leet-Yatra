import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        int[][] id = new int[m][n];
        int sr = 0, sc = 0, count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (classroom[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                } else if (classroom[i].charAt(j) == 'L') {
                    id[i][j] = count++;
                }
            }
        }

        int full = (1 << count) - 1;

        boolean[][][][] vis =
            new boolean[m][n][energy + 1][1 << count];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc, energy, full});
        vis[sr][sc][energy][full] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] cur = q.poll();

                int r = cur[0];
                int c = cur[1];
                int e = cur[2];
                int mask = cur[3];

                if (mask == 0) return moves;
                if (e == 0) continue;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                        continue;

                    char ch = classroom[nr].charAt(nc);

                    if (ch == 'X') continue;

                    int ne = e - 1;
                    int nm = mask;

                    if (ch == 'R')
                        ne = energy;

                    if (ch == 'L')
                        nm &= ~(1 << id[nr][nc]);

                    if (!vis[nr][nc][ne][nm]) {
                        vis[nr][nc][ne][nm] = true;
                        q.offer(new int[]{nr, nc, ne, nm});
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}