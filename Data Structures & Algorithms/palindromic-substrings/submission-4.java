class Solution {
    public int countSubstrings(String s) {
        int len = s.length();

        int count=0;
        Boolean[][] dp= new Boolean[len][len];
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(isPalindrome(s,i,j,dp)){
                    count++;
                }
            }
        }
        return count;
        
    }

    private boolean isPalindrome(String s, int start, int end,Boolean[][] dp){
        if(start> end){
            return true;
        }
        if(dp[start][end]!=null){
            return dp[start][end];
        }

        if(s.charAt(start) != s.charAt(end)){
            return dp[start][end]=false;
        }

        return dp[start][end]=isPalindrome(s, start+1,end-1,dp);
    }
}
