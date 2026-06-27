class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        int maxlen = 1;

        if(map.containsKey(1)){
            int countOne = map.get(1);

            if(countOne%2 == 0){
                maxlen = Math.max(maxlen , countOne -1);
            }else{
                maxlen = Math.max(maxlen , countOne);
            }
        }

        for(int base : map.keySet()){
            if(base == 1) continue;

            int currentLen = 0;
            int currentBase = base;

            while(currentBase <= 1000000000 && map.containsKey((int) currentBase) && map.get((int) currentBase) >= 2){
                currentLen += 2;
                currentBase = currentBase * currentBase;
            }

            if(currentBase <= 1000000000 && map.containsKey((int) currentBase)){
                currentLen += 1;
            }else{
                currentLen -= 1;
            }

            maxlen = Math.max(maxlen , currentLen);
        }

        return maxlen;
    }
}