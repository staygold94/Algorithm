import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        // 기본값 지정
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        StringBuilder sb = new StringBuilder();

        for(int j=0; j<t; j++) {
            int n = Integer.parseInt(br.readLine());

            if(dp[n] == 0) {
                for(int i=4; i<=n; i++) {
                    if(dp[i] == 0) dp[i] = ((dp[i-1] + dp[i-2]) % 1_000_000_009 +  dp[i-3]) % 1_000_000_009;
                }
            }
            sb.append(dp[n] + "\n");
        }
        System.out.print(sb.toString());
    }
}