import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(findDp(n) + "\n");
        }
        System.out.print(sb.toString());
    }

    public static Long findDp(int n) {
        long[] dp = new long[Math.max(n+1, 6)];
        // 초기값 넣기
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;
        dp[4] = 2L;
        dp[5] = 2L;

        for(int i=6; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-5];
        }

        return dp[n];
    }
}