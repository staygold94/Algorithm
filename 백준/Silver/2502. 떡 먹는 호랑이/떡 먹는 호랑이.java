import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[2][d+1];

        // 초기값
        dp[0][1] = 1;
        dp[1][2] = 1;

        for(int i=3; i<=d; i++) {
            dp[0][i] = dp[0][i-1] + dp[0][i-2];
            dp[1][i] = dp[1][i-1] + dp[1][i-2];
        }

        int a = dp[0][d];
        int b = dp[1][d];

        for(int i=1; i <= k / a; i++) {
            if((k - i*a) % b == 0) {
                System.out.println(i);
                System.out.println((k - i*a) / b);
                break;
            }
        }
    }
}
