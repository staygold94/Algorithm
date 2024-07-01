class Solution {
    public long solution(int n) {
        // 홀수인 경우 리턴
        if(n%2 != 0) return 0;
        
        long mod = 1000000007L;
        long[] dp = new long[n+1];
        dp[0] = 1;
        if(n>=2) dp[2] = 3;
        
        for(int i=4; i<=n; i+=2) {
            dp[i] = (dp[i-2] * 3);
            for(int j=i-4; j>=0; j-=2) {
                dp[i] += (dp[j] * 2);
            }
            dp[i] %= mod;
        }
        
        return dp[n];
    }
}