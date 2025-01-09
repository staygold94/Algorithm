import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[][] dp = new int[2][n];
        int max;

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 초기값
        dp[0][0] = arr[0];
        dp[1][0] = 0;
        max = arr[0];

        for(int i=1; i<n; i++) {

            // 제거 안한 배열
            dp[0][i] = Math.max(dp[0][i-1] + arr[i], arr[i]);

            // 1개 제거한 배열
            // dp[0][i-1] 제거안한 배열에 이번에 제거하기 vs dp[1][i-1](제거된 배열) + arr[i](제거하지 않는 현재)
            dp[1][i] = Math.max(dp[0][i-1], dp[1][i-1] + arr[i]);

            // 제거 안한 배열 vs  1개 제거한 배열
            max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
        }

        System.out.println(max);
    }
}