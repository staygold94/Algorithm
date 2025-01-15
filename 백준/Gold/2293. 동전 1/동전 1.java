import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int[] dp = new int[k+1];

        for(int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);

        // 초기값
        dp[0] = 1;  // 0원이면 아무 동전도 선택하지 않는 경우로 1가지 경우의 수만 있음

        for(int coin : coins) {
            for(int j=coin; j<=k; j++) {
                dp[j] += dp[j-coin];
            }
        }

        System.out.println(dp[k]);
    }
}
