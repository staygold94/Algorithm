import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = Math.abs(n);
        int[] dp = new int[num+1];

        // 초기값
        if(num >= 1) dp[1] = 1;

        int mod = 1000000000;
        if(n < 0) {
            for(int i=2; i<=num; i++) {
                dp[i] = (dp[i-2] - dp[i-1]) % mod;
            }
        } else {
            for(int i=2; i<=n; i++) {
                dp[i] = (dp[i-1] + dp[i-2]) % mod;
            }
        }

        System.out.println(dp[num] > 0 ? 1 : (dp[num] == 0) ? 0 : -1);
        System.out.println(Math.abs(dp[num]));
    }
}