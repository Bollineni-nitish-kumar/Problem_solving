class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1){
            return s;
        }
        String[][] dp = new String[s.length()][s.length()];
        String lp = longestPalindrome(s,0,s.length()-1,dp);
        return lp;   
    }

    private String longestPalindrome(String s, int start, int end,String[][] dp){
        if(start > end){
            return "";
        }
        if(start == end){
            return s.substring(start,end+1);
        }

        if(dp[start][end] != null){
            return dp[start][end];
        }

        if(isPalindrome(s,start,end)){
            return dp[start][end]=s.substring(start,end+1);
        }

        String sI = longestPalindrome(s,start,end-1,dp);
        String sNI = longestPalindrome(s,start+1,end,dp);

        if(sI.length() <= sNI.length()){
            return dp[start][end]=sNI;
        }else{
            return dp[start][end]=sI;
        }
    }

    private boolean isPalindrome(String s, int start, int end){
        if(s.isEmpty()){
            return false;
        }
        if(start == end){
            return true;
        }

       for (int i = start, j = end; i < j; i++, j--) {
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }
       }
       return true;

    }
}
