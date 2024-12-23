import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<=n; i++) {
            dp[i][1] = 1;
        }

        for(int i=1; i<=m; i++) {
            dp[1][i] = 1;
        }

        for(int i=2; i<=n; i++) {
            for(int j=2; j<=m; j++) {
                int mod = 1_000_000_007;
                dp[i][j] = (((dp[i-1][j] + dp[i][j-1]) % mod) + dp[i-1][j-1]) % mod;
            }
        }
        System.out.println(dp[n][m]);
    }
}