class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long total = 0;
        long curr = 0, max1=0;
        int mod = 1_000_000_007;

        for(int x : arr){
            curr = Math.max(0, curr+x);
            max1=Math.max(max1 , curr);
            total+=x;
        }

        if(k == 1) return (int)(max1%mod);

        curr=0;
        long max2=0;

        for(int i=0;i<2*arr.length;i++){
            curr=Math.max(0,curr+arr[i%arr.length]);
            max2=Math.max(max2,curr);
        }

        if(total>0){
            max2+=(long)(k-2)*total;
        }

        return (int)(max2%mod);
    }
}