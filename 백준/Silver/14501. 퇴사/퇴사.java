import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n+1];
        int[] costs = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            costs[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i]);

            if(i + times[i] <= n + 1) {
                dp[i + times[i] - 1] = Math.max(dp[i + times[i] - 1], dp[i-1] + costs[i]);
            }
        }

        System.out.println(dp[n]);
    }
}