import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] dp = new int[2][41];

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i=2; i<=40; i++) {
            dp[0][i] = dp[0][i-1] + dp[0][i-2];
            dp[1][i] = dp[1][i-1] + dp[1][i-2];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[0][num] + " " + dp[1][num] + "\n");
        }
        System.out.print(sb.toString());
    }
}