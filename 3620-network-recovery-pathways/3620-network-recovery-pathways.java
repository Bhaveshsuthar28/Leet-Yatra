class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<int[]>[] g = new ArrayList[n];

        for(int i=0;i<n;i++){
            g[i] = new ArrayList<>();
        }

        int[] indeg = new int[n];
        int hi=0;

        for(int[] e : edges){
            g[e[0]].add(new int[]{e[1] , e[2]});
            indeg[e[1]]++;
            hi = Math.max(hi , e[2]);
        }

        int[] topo = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(indeg[i] == 0){
                q.offer(i);
            }
        }

        int idx = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            topo[idx++] = u;
            for(int[] e : g[u]){
                if(--indeg[e[0]] == 0){
                    q.offer(e[0]);
                }
            }
        }

        int lo = 0 , ans = -1;

        while(lo <= hi){
            int mid = (lo + hi)/2;

            long[] dp = new long[n];
            Arrays.fill(dp , Long.MAX_VALUE);
            dp[0]=0;

            for(int u : topo){
                if(dp[u] == Long.MAX_VALUE){
                    continue;
                }

                for(int[] e : g[u]){
                    int v = e[0], w = e[1];

                    if(w < mid) continue;
                    if(v != n-1 && !online[v]) continue;

                    dp[v] = Math.min(dp[v] , dp[u] + w);
                }
            }


            if(dp[n-1] <= k){
                ans = mid;
                lo=mid+1;
            }else{
                hi = mid-1;
            }
        }

        return ans;
    }
}