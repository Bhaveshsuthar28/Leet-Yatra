class Solution {
    private long ans = 0;
    
    public long countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        long[] pref = new long[n + 1];

        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (nums[i] == target ? 1 : -1);
        }

        long[] temp = new long[n + 1];
        mergeSort(pref, temp, 0, n);

        return ans;
    }

    private void mergeSort(long[] a, long[] temp, int l, int r) {

        if (l >= r) return;

        int mid = (l + r) >> 1;

        mergeSort(a, temp, l, mid);
        mergeSort(a, temp, mid + 1, r);

        int i = l;
        int j = mid + 1;

        while (i <= mid && j <= r) {

            if (a[i] < a[j]) {
                ans += (r - j + 1);
                i++;
            } else {
                j++;
            }
        }

        i = l;
        j = mid + 1;

        int k = l;

        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= mid) temp[k++] = a[i++];
        while (j <= r) temp[k++] = a[j++];

        for (i = l; i <= r; i++)
            a[i] = temp[i];
    }
}