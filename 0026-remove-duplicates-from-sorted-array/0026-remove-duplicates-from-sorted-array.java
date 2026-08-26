class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n== 1) return 1;

        int left = 0, right = 1 , index = 1;
        int ans = 1;

        while(right != n){
            if(nums[left] == nums[right]){
                right++;
            }else{
                nums[index] = nums[right];
                index++;
                left = right;
                right++;
                ans++;
            }
        }

        return ans;
    }
}