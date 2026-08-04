class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        Integer[][] dp = new Integer[m][n];
        return helper(s, t, 0, 0, dp);
    }
    private int helper(String s, String t, int i, int j, Integer[][] dp) {
        if ( j == t.length())
                return 1;
        if ( i == s.length())
                return 0;
            
        if (dp[i][j] != null) return dp[i][j];

        int count = 0;
        if (s.charAt(i) == t.charAt(j)) {
            
            int inc= helper(s, t, i + 1, j + 1, dp);
            int exc= helper(s, t, i + 1, j, dp);
            count = inc+exc;
        } 
        else {
            
            count = helper(s, t, i + 1, j, dp);
        }

            return dp[i][j] = count;
    }
}