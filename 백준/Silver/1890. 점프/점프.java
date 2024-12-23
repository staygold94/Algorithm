import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        long[][] dp = new long[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기값
        dp[0][0] = 1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {

                // 움직일 수 없는 칸인 경우 pass
                if(arr[i][j] == 0 || dp[i][j] == 0) continue;

                // 아래, 오른쪽으로 움직일 수 있는 경우 dp 더해감
                if(i + arr[i][j] < n) dp[i + arr[i][j]][j] += dp[i][j];
                if(j + arr[i][j] < n) dp[i][j + arr[i][j]] += dp[i][j];
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}