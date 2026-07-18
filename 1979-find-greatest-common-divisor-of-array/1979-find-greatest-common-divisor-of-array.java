class Solution {
    public int findGCD(int[] nums) {
        int max = nums[0] , min = nums[0];

        for(int num : nums){
            if(num > max){
                max = num;
            }else if(num < min){
                min = num;
            }
        }

        int gcd = GCD(max , min);

        return gcd;
    }

    public int GCD(int a , int b){
        if(b == 0){
            return a;
        }

        return GCD(b, a % b);
    }
}