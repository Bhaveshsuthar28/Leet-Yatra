class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int totalOnes = 0;
        int maxZeroGain = 0;
        int prevZeros = -1;
        int currentZeros = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
                if (currentZeros > 0) {
                    if (prevZeros >= 0) {
                        maxZeroGain = Math.max(maxZeroGain, prevZeros + currentZeros);
                    }
                    prevZeros = currentZeros;
                    currentZeros = 0;
                }
            } else {
                currentZeros++;
            }
        }
        
        if (currentZeros > 0 && prevZeros >= 0) {
            maxZeroGain = Math.max(maxZeroGain, prevZeros + currentZeros);
        }
        
        return totalOnes + maxZeroGain;
    }
}
