int** threeSum(int* nums, int numsSize, int* returnSize, int** returnColumnSizes) {
    *returnSize = 0;
    if(numsSize < 3) return NULL;

    for(int i = 0; i < numsSize - 1; i++) {
        for(int j = i + 1; j < numsSize; j++) {
            if(nums[i] > nums[j]) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
    }

    int cap = 16;
    int** res = malloc(sizeof(int*) * cap);
    *returnColumnSizes = malloc(sizeof(int) * cap);

    for(int i = 0; i < numsSize - 2; i++) {
        if(i > 0 && nums[i] == nums[i - 1]) continue;
        int l = i + 1, r = numsSize - 1;
        while(l < r) {
            int sum = nums[i] + nums[l] + nums[r];
            if(sum == 0) {
                if(*returnSize == cap) {
                    cap *= 2;
                    res = realloc(res, sizeof(int*) * cap);
                    *returnColumnSizes = realloc(*returnColumnSizes, sizeof(int) * cap);
                }
                res[*returnSize] = malloc(3 * sizeof(int));
                res[*returnSize][0] = nums[i];
                res[*returnSize][1] = nums[l];
                res[*returnSize][2] = nums[r];
                (*returnColumnSizes)[*returnSize] = 3;
                (*returnSize)++;
                l++;
                r--;
                while(l < r && nums[l] == nums[l - 1]) l++;
                while(l < r && nums[r] == nums[r + 1]) r--;
            } else if(sum < 0) {
                l++;
            } else {
                r--;
            }
        }
    }

    return res;
}
