class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max_sum = nums[0];
        int curr_sum = nums[0];

        for(int i=1; i<n;i++){
            curr_sum = Math.max(nums[i] , curr_sum + nums[i]);
            max_sum = Math.max(curr_sum , max_sum);
        }

        return max_sum;
    }

}