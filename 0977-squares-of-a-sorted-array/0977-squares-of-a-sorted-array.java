class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int left = 0 , right = n-1;

        for(int i=n-1;i>=0;i--){
            int rightsq = nums[right]*nums[right];
            int leftsq = nums[left]*nums[left];

            if(rightsq > leftsq){
                ans[i] = rightsq;
                right--;
            }else{
                ans[i] = leftsq;
                left++;
            }
        }

        return ans;
    }
}