class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int modiji=1_000_000_007;
        int n = s.length();

        long[] pow10=new long[n+1];
        pow10[0]=1;
        for(int i=1;i<=n;i++){
            pow10[i]=(pow10[i-1]*10)%modiji;
        }

        int[] digitSum=new int[n+1];
        int[] nonZeroCount=new int[n+1];
        long[] prefixValue=new long[n+1];

        for(int i=1;i<=n;i++){
            int d=s.charAt(i-1) -'0';

            digitSum[i] =digitSum[i-1]+d;
            nonZeroCount[i]=nonZeroCount[i-1]+(d!=0 ? 1:0);

            if(d!=0){
                prefixValue[i]=(prefixValue[i-1]*10 + d)%modiji;
            }else{
                prefixValue[i]=prefixValue[i-1];
            }
        }

        int[] ans=new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int sum = digitSum[r + 1] - digitSum[l];
            int cnt = nonZeroCount[r + 1] - nonZeroCount[l];

            long concat = (prefixValue[r + 1]
                    - (prefixValue[l] * pow10[cnt]) % modiji
                    + modiji) % modiji;

            ans[i] = (int) ((concat * sum) % modiji);
        }

        return ans;
    }
}