import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[2][n+1];

        // 초기값
        dp[0][1] = 1;
        dp[1][1] = 4;

        for(int i=2; i<=n; i++) {
            dp[0][i] = dp[0][i-1] + dp[0][i-2];
            dp[1][i] = dp[1][i-1] + dp[0][i] * 2;
        }

        System.out.println(dp[1][n]);
    }
}