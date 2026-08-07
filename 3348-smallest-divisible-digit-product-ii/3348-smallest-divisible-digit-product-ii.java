class Solution {
    private static final int[][] DIGIT_FACTORS = {
        {0,0,0,0}, {0,0,0,0}, {1,0,0,0}, {0,1,0,0}, {2,0,0,0},
        {0,0,1,0}, {1,1,0,0}, {0,0,0,1}, {3,0,0,0}, {0,2,0,0}
    };

    public String smallestNumber(String num, long t) {
        int[] req = factorizeT(t);
        if (req == null) return "-1";

        int n = num.length();
        int[] total = new int[4];
        int firstZero = -1;
        for (int i = 0; i < n; i++) {
            int d = num.charAt(i) - '0';
            if (d == 0 && firstZero == -1) firstZero = i;
            add(total, DIGIT_FACTORS[d]);
        }

        int[] minCnt = getFactorCount(req);
        int minLen = sum(minCnt);
        if (minLen > n) return construct(minCnt, minLen);

        if (firstZero == -1 && covers(total, req)) return num;

        int limit = (firstZero == -1) ? n : firstZero;
        int[] prefix = total.clone();

        for (int i = n - 1; i >= 0; i--) {
            int d = num.charAt(i) - '0';
            subtract(prefix, DIGIT_FACTORS[d]);
            int space = n - 1 - i;
            if (i > limit) continue;

            for (int big = d + 1; big <= 9; big++) {
                int[] need = need(req, prefix, DIGIT_FACTORS[big]);
                int[] fillCnt = getFactorCount(need);
                int fillLen = sum(fillCnt);
                if (fillLen <= space) {
                    StringBuilder sb = new StringBuilder(n);
                    sb.append(num, 0, i);
                    sb.append((char) ('0' + big));
                    appendSorted(sb, fillCnt, space);
                    return sb.toString();
                }
            }
        }

        return construct(minCnt, n + 1);
    }

    private int[] factorizeT(long t) {
        int[] r = new int[4];
        int[] primes = {2, 3, 5, 7};
        for (int i = 0; i < 4; i++) {
            while (t % primes[i] == 0) { t /= primes[i]; r[i]++; }
        }
        return t == 1 ? r : null;
    }

    private int[] getFactorCount(int[] req) {
        int a = req[0], b = req[1], c = req[2], d = req[3];
        int[] cnt = new int[10];
        cnt[9] = b / 2; b %= 2;
        cnt[8] = a / 3; a %= 3;
        if (a > 0 && b > 0) { cnt[6] = 1; a--; b--; }
        if (a == 2) cnt[4] = 1;
        else if (a == 1) cnt[2] = 1;
        if (b == 1) cnt[3] = 1;
        cnt[7] = d;
        cnt[5] = c;
        return cnt;
    }

    private int sum(int[] cnt) {
        int s = 0;
        for (int v : cnt) s += v;
        return s;
    }

    private void add(int[] a, int[] b) {
        for (int i = 0; i < 4; i++) a[i] += b[i];
    }

    private void subtract(int[] a, int[] b) {
        for (int i = 0; i < 4; i++) a[i] -= b[i];
    }

    private boolean covers(int[] have, int[] req) {
        for (int i = 0; i < 4; i++) if (have[i] < req[i]) return false;
        return true;
    }

    private int[] need(int[] req, int[] prefix, int[] bigDigit) {
        int[] r = new int[4];
        for (int i = 0; i < 4; i++) {
            int provided = prefix[i] + bigDigit[i];
            r[i] = Math.max(0, req[i] - provided);
        }
        return r;
    }

    private void appendSorted(StringBuilder sb, int[] cnt, int space) {
        int pad = space - sum(cnt);
        for (int i = 0; i < pad; i++) sb.append('1');
        for (int digit = 2; digit <= 9; digit++) {
            for (int k = 0; k < cnt[digit]; k++) sb.append((char) ('0' + digit));
        }
    }

    private String construct(int[] cnt, int len) {
        StringBuilder sb = new StringBuilder(len);
        appendSorted(sb, cnt, len);
        return sb.toString();
    }
}