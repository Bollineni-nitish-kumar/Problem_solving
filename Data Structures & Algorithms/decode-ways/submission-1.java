class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return ways(s,0,s.length(),dp);
    }

    private int ways(String s, int start, int end,int[] dp){
        if(start > end){
            return 0;
        }
        if(start == end){
            return 1;
        }

        if(s.charAt(start)=='0'){
            return 0;
        }

        if(dp[start]!=-1){
            return dp[start];
        }
        int oneCharWays = ways(s,start+1,end,dp);
        int twoCharWays=0;
        
        if(start+1 < end){
            String twoChars = s.charAt(start)+""+s.charAt(start+1);
            Integer charNum = Integer.parseInt(twoChars);
            if(charNum <=26){
                twoCharWays = ways(s,start+2,end,dp);
            }
        }
        return dp[start]=oneCharWays+twoCharWays;

    }
}
