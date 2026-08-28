class Solution {
    public int rotatedDigits(int n) {
        int output = 0;
        for(int i=1;i<=n;i++){
            if(isValid(i)){
                output++;
            }
        }

        return output;
    }

    private boolean isValid(int x){
        boolean change = false;
        while(x > 0){
            int n = x%10;

            if(n == 3 || n == 4 || n == 7){
                return false;
            }else if(n == 2 || n == 5 || n == 6 || n == 9){
                change = true;
            }

            x/=10;
        }

        return change;

    }
}