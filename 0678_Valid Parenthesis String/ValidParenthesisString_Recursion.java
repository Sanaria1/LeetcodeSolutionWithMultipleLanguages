class Solution {
    public boolean checkValidString(String s) {
        int[][] memo = new int[s.length()][s.length()];
        return isValid(s, 0, s.length() - 1, memo);
    }
    
    private boolean isValid(String s, int l , int r, int[][] memo) {
        if(l > r) return true;
        if(memo[l][r] > 0) return memo[l][r] == 2;
        
        char chL = s.charAt(l);
        char chR = s.charAt(r);
        
        if(l == r) {
            memo[l][r] = chL == '*' ? 2 : 1;
            return memo[l][r] == 2;
        }
        
        if((chL == '(' || chL == '*') && (chR == ')' || chR == '*') && isValid(s, l+1, r-1, memo)) {
            memo[l][r] = 2;
            return true;
        }
        
        for(int p=l;p<r;p++) {
            if(isValid(s, l, p, memo) && isValid(s, p+1, r, memo)) {
                memo[l][r] = 2;
                return true;
            }
        }
        
        memo[l][r] = 1;
        return false;
    }
}