class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int curr_max = nums[0];
        int curr_min = nums[0];
        int max_sum = nums[0];
        int min_sum = nums[0];

        for(int i=1;i<n;i++){
            curr_max=Math.max(nums[i] , curr_max+nums[i]);
            curr_min=Math.min(nums[i] , curr_min+nums[i]);

            max_sum = Math.max(max_sum , curr_max);
            min_sum = Math.min(min_sum , curr_min);
        }

        int ans = Math.max(max_sum , Math.abs(min_sum));

        return ans;
    }
}