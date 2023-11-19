import java.io.*;

public class Main {

    static Long[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 (1 ≤ N ≤ 100)
        Long num = Long.parseLong(br.readLine());

        // 케이스 갯수만큼 반복문
        for(int i=0; i<num; i++) {
            int n = Integer.parseInt(br.readLine());
            dp = new Long[n+1];
            dp[0] = 0L;  // 초기값

            for(int j=1; j<=n; j++) {
                solve(j);
            }
            System.out.println(dp[n]);
        }
    }

    static Long solve(int n) {

        if(dp[n] == null) {

            if(n>4) {
                dp[n] = dp[n-5] + dp[n-1];
            } else if(n==4) {
                dp[n] = 2L;
            } else{
                dp[n] = 1L;
            }
        }

        return dp[n];
    }
}
