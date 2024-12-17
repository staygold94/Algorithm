import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[2][n+1];

        // 초기값
        dp[0][0] = 1;
        dp[1][0] = 0;

        for(int i=1; i<=n; i++) {
            dp[0][i] = dp[1][i-1];
            dp[1][i] = dp[0][i-1] + dp[1][i-1];
        }

        System.out.println(dp[0][n] + " " + dp[1][n]);
    }
}
