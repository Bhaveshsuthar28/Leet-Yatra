class Solution {
    public long sumAndMultiply(int n) {
        String s=String.valueOf(n);
        StringBuilder ans=new StringBuilder();
        int sum=0;

        for(char ch : s.toCharArray()){
            if(ch != '0'){
                ans.append(ch);
                sum+=ch-'0';
            }
        }

        if(ans.length() ==0)return 0;
        long x = Long.parseLong(ans.toString());

        return x*sum;
    }
}