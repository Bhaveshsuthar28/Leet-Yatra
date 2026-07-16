class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        int mx = 0;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);

            int a = nums[i], b = mx;
            while (b != 0) {
                int t = a % b;
                a = b;
                b = t;
            }
            arr[i] = a;
        }

        java.util.Arrays.sort(arr);

        long ans = 0;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int a = arr[i], b = arr[j];
            while (b != 0) {
                int t = a % b;
                a = b;
                b = t;
            }
            ans += a;
        }

        return ans;
    }
}