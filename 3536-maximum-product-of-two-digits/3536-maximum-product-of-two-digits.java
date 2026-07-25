class Solution {
    public int maxProduct(int n) {
        int[] digits = Integer.toString(n).chars().map(c -> c-'0').toArray();
        int len = digits.length-1;

        Arrays.sort(digits);

        return digits[len] * digits[len-1];
    }
}