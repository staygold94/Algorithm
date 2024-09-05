import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][k+1];

        // 초기값
        for(int i=1; i<=n; i++) {
            dp[i][1] = 1;
        }

        for(int i=1; i<=k; i++) {
            dp[1][i] = i;
        }

        // dp 구하기
        for(int i=2; i<=n; i++) {
            for(int j=2; j<=k; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1_000_000_000;
            }
        }
        System.out.println(dp[n][k]);
    }
}