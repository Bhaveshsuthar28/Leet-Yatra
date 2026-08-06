class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] g = new ArrayList[n];
        List<Integer>[] rg = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            rg[i] = new ArrayList<>();
        }

        for (int[] e : invocations) {
            g[e[0]].add(e[1]);
            rg[e[1]].add(e[0]);
        }

        boolean[] sus = new boolean[n];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(k);
        sus[k] = true;

        while (!dq.isEmpty()) {
            int u = dq.poll();
            for (int v : g[u]) {
                if (!sus[v]) {
                    sus[v] = true;
                    dq.offer(v);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!sus[i]) {
                for (int v : g[i]) {
                    if (sus[v]) {
                        List<Integer> ans = new ArrayList<>();
                        for (int j = 0; j < n; j++) ans.add(j);
                        return ans;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!sus[i]) ans.add(i);
        }
        return ans;
    }
}