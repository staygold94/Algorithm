import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dp, INF);

        // dp[0] 초기화
        dp[0] = 0;

        for(int i=1; i<=n; i++) {
            // 기본 갯수 (1+1+1... 이런 식)
            dp[i] = i;

            // 최소 갯수 찾기
            for(int j=2; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}