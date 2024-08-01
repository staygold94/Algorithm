import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // (1 ≤ N ≤ 30)
        int[] dp = new int[n+1];

        // 홀수인 경우 0개
        if(n % 2 == 1) {
            dp[n] = 0;

        // 짝수인 경우
        } else {
            // 초기값
            dp[0] = 1;
            dp[2] = 3;

            for(int i=4; i<=n; i+=2) {
                dp[i] = dp[i-2] * dp[2];
                for(int j=i-4; j>=0; j-=2) {
                    dp[i] += dp[j] * 2;
                }
            }
        }
        System.out.println(dp[n]);
    }
}