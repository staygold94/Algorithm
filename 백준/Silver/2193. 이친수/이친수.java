import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n][2];
        dp[0][0] = 0L;
        dp[0][1] = 1L;

        for(int i=1; i<n; i++) {
            for(int j=0; j<2; j++) {
                if(j==0) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j+1];
                } else {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }

        System.out.println(dp[n-1][0] + dp[n-1][1]);
    }
}
