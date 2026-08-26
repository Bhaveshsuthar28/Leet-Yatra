class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase().replaceAll("[^a-z0-9]" , "");

        int l=0,r=str.length()-1;
        while(l<r){
            if(str.charAt(l) == str.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }

        return true;
    }
}