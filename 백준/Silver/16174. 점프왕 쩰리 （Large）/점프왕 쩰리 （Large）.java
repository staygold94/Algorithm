import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 초기값
        dp[0][0] = 1;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(dp[i][j] != 0) {
                    if(i + arr[i][j] < n) dp[i + arr[i][j]][j] += dp[i][j];
                    if(j + arr[i][j] < n) dp[i][j + arr[i][j]] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n-1][n-1] == 0 ? "Hing" : "HaruHaru");
    }
}