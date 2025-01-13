import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][][] dp = new long[10][n+1][1<<10];

        // 초기값
        for(int i=1; i<=9; i++) {
            dp[i][1][1<<i] = 1;
        }

        long mod = 1000000000;
        for(int i=2; i<=n; i++) {
            for(int j=0; j<=9; j++) {
                for(int k=0; k<(1<<10); k++) {
                    int v = k | (1<<j);

                    if(j == 0) dp[j][i][v] += dp[j+1][i-1][k] % mod;
                    else if(j == 9) dp[j][i][v] += dp[j-1][i-1][k] % mod;
                    else dp[j][i][v] += (dp[j+1][i-1][k] % mod + dp[j-1][i-1][k] % mod);

                    dp[j][i][v] %= mod;
                }
            }
        }

        long answer = 0;
        for(int i=0; i<=9; i++) {
            answer += dp[i][n][(1<<10)-1] % mod;
            answer %= mod;
        }
        System.out.println(answer);
    }
}