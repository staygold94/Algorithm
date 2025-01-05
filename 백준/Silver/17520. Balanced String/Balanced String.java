import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        // 초기값
        dp[1] = 2;
        
        for(int i=2; i<=n; i++) {
            if(i % 2 == 0) dp[i] = dp[i-1];
            else dp[i] = (dp[i-1] * 2) % 16769023;
        }

        System.out.println(dp[n]);
    }
}