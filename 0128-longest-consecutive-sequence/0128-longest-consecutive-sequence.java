class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if(n ==0) return 0;
        
        Arrays.sort(nums);

        int max = 1, curr=1;

        for(int i=1;i<n;i++){
            if(nums[i] == nums[i-1]+1){
                curr++;
            }else if(nums[i] == nums[i-1]){
                continue;
            }else{
                max = Math.max(max , curr);
                curr = 1;
            }
        }

        return Math.max(max, curr);
    }
}