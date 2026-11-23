class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        int len = s.length();

        if(len-1 >=0 && s.charAt(len-1) !='0'){
            dp[len-1]=1;
        }
        if(len-2 >=0 && s.charAt(len-2) !='0'){
            String twoChars = s.charAt(len-2)+""+s.charAt(len-1);
            Integer charNum = Integer.parseInt(twoChars);
            if(charNum <=26){
                dp[len-2] = 1+dp[len-1];
            }else{
                dp[len-2] = 0+dp[len-1];
            }
        }

        for(int i=len-3;i>=0;i--){
            if(s.charAt(i)=='0'){
                dp[i]= 0;
                continue;
            }else{
                int oneCharWays = dp[i+1];
                int twoCharWays=0;
                String twoChars = s.charAt(i)+""+s.charAt(i+1);
                Integer charNum = Integer.parseInt(twoChars);
                if(charNum <=26){
                    twoCharWays = dp[i+2];
                }
                dp[i] = oneCharWays+twoCharWays;
            }
        }
        return dp[0];
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
