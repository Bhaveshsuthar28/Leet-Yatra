class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        HashSet<Integer> pairXor = new HashSet<>();
        BitSet seen = new BitSet(2048);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pairXor.add(nums[i] ^ nums[j]);
            }
        }

        for (int x : pairXor) {
            for (int num : nums) {
                seen.set(x ^ num);
            }
        }

        for (int num : nums) {
            seen.set(num);
        }

        return seen.cardinality();
    }
}