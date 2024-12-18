import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[4][100001];

        // 초기값
        dp[1][1] = 1L;   // 1
        dp[2][2] = 1L;   // 2
        dp[1][3] = 1L;   // 2+1
        dp[2][3] = 1L;   // 1+2
        dp[3][3] = 1L;   // 3
        
        long mod = 1_000_000_009L;

        for(int i=4; i<=100000; i++) {
            dp[1][i] = (dp[2][i-1] + dp[3][i-1]) % mod;
            dp[2][i] = (dp[1][i-2] + dp[3][i-2]) % mod;
            dp[3][i] = (dp[1][i-3] + dp[2][i-3]) % mod;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            long sum = (dp[1][n] + dp[2][n] + dp[3][n]) % mod;
            sb.append(sum + "\n");
        }
        System.out.print(sb.toString());
    }
}
