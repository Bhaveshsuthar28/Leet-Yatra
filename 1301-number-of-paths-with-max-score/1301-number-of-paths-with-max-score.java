class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size(), mod=1_000_000_007;
        int[][] score = new int[n][n];
        int[][] ways= new int[n][n];

        ways[n-1][n-1]=1;

        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(board.get(i).charAt(j) == 'X') continue;

                if(i !=n-1 || j!=n-1){
                    int best=-1;

                    if(i+1 <n) best=Math.max(best,score[i+1][j]);
                    if(j+1 <n) best=Math.max(best,score[i][j+1]);
                    if(i+1 <n && j+1<n) best=Math.max(best,score[i+1][j+1]);

                    if(best ==-1) continue;
                    score[i][j]=best;
                    if(i+1<n && score[i+1][j] ==best){
                        ways[i][j]=(ways[i][j] + ways[i+1][j])%mod;
                    }
                    if(j+1<n && score[i][j+1] ==best){
                        ways[i][j]=(ways[i][j] + ways[i][j+1])%mod;
                    }
                    if(i+1<n && j+1<n && score[i+1][j+1] ==best){
                        ways[i][j]=(ways[i][j] + ways[i+1][j+1])%mod;
                    }

                    char c = board.get(i).charAt(j);
                    if(c !='E'){
                        score[i][j] += c-'0';
                    }
                }
            }
        }

        return ways[0][0] == 0 ? new int[]{0,0}:new int[]{score[0][0] , ways[0][0]};
    }
}