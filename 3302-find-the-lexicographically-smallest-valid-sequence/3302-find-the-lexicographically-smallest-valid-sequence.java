class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[] suf = new int[n + 1];

        int j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1];
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                suf[i]++;
                j--;
            }
        }

        int[] ans = new int[m];
        int i = 0, k = 0;

        while (i < n && k < m) {
            if (word1.charAt(i) == word2.charAt(k)) {
                ans[k++] = i++;
            } else if (suf[i + 1] >= m - k - 1) {
                ans[k++] = i++;
                break;
            } else {
                i++;
            }
        }

        while (i < n && k < m) {
            if (word1.charAt(i) == word2.charAt(k)) {
                ans[k++] = i;
            }
            i++;
        }

        return k == m ? ans : new int[0];
    }
}