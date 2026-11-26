class Solution {
    public int countSubstrings(String s) {
        int len = s.length();

        int count=0;
        boolean[][] dp= new boolean[len][len];
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=1 || dp[i+1][j-1]){
                        dp[i][j]=true;
                        count++;
                    }
                }
            }
        }

        /*
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(isPalindrome(s,i,j,dp)){
                    count++;
                }
            }
        }
        */
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
