class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int pivot=n-2;

        while(pivot>=0&&nums[pivot]>=nums[pivot+1]){
            pivot--;
        }

        if(pivot>=0){
            int i=n-1;
            while(nums[i] <=nums[pivot]){
                i--;
            }

            swap(nums,pivot,i);
        }

        reverse(nums,pivot+1,n-1);
    }

    public void swap(int[] nums,int i, int pivot){
        int temp = nums[pivot];
        nums[pivot] = nums[i];
        nums[i]=temp;
    }

    public void reverse(int[] nums,int left, int right){
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
}