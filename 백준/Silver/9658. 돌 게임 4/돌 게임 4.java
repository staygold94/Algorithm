import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[n+1];

        dp[1] = false;
        if(n >= 2) dp[2] = true;
        if(n >= 3) dp[3] = false;
        if(n >= 4) dp[4] = true;

        for(int i=5; i<=n; i++) {
            dp[i] = !dp[i-1] || !dp[i-3] || !dp[i-4];
        }
        System.out.println(dp[n] ? "SK" : "CY");
    }
}