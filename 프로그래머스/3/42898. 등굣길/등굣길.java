class Solution {
    public int solution(int m, int n, int[][] puddles) {

        int[][] dp = new int[n][m];

        // 물 웅덩이 값 표식
        for(int i=0; i<puddles.length; i++) {
            dp[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }

        // 시작점 초기화
        dp[0][0] = 1;

        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                
                // 웅덩이라면 0으로 초기화 후 continue
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                // 이전값이 있다면 나머지 값을 더해준다.
                if(i != 0) dp[i][j] += dp[i-1][j] % 1000000007;
                if(j != 0) dp[i][j] += dp[i][j-1] % 1000000007;

            }
        }

        return dp[n-1][m-1] % 1000000007;
    }
}