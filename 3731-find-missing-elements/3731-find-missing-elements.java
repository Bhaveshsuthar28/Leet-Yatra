class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max =Integer.MIN_VALUE  , min = Integer.MAX_VALUE;
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int x : nums){
            min=Math.min(x , min);
            max=Math.max(x , max);
            set.add(x);
        }

        for(int i=min+1; i<max; i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }

        return ans;

    }
}