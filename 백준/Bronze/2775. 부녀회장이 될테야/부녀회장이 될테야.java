import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] dp = new int[15][15];

        for(int i=0; i<15; i++) {
            dp[0][i] = i;
        }

        for(int i=1; i<15; i++) {
            for(int j=1; j<15; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[k][n] + "\n");
        }
        System.out.print(sb.toString());
    }
}