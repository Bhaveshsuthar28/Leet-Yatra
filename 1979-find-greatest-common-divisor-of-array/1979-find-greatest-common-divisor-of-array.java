class Solution {
    public int findGCD(int[] nums) {
        int max = nums[0] , min = nums[0];

        for(int num : nums){
            if(num > max) max = num;
            if(num < min) min = num;
        }

        while(min !=0){
            int temp = max%min;
            max=min;
            min=temp;
        }

        return max;
    }
}