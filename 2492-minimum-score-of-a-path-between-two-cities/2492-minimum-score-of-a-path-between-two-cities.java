class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] road : roads){
            graph.get(road[0]).add(new int[]{road[1] , road[2]});
            graph.get(road[1]).add(new int[]{road[0] , road[2]});
        }

        boolean[] visited = new boolean[n+1];
        return dfs(1,graph, visited, Integer.MAX_VALUE);
    }

    private int dfs(int city,List<List<int[]>> graph,boolean[] visited,int minScore){
        visited[city] = true;
        for(int[] neighbor : graph.get(city)){
            minScore=Math.min(minScore,neighbor[1]);

            if(!visited[neighbor[0]]){
                minScore=dfs(neighbor[0],graph,visited,minScore);
            }
        }

        return minScore;
    }
}