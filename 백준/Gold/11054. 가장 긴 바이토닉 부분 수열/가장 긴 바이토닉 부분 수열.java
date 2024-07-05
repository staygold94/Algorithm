import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] dp = new int[2][n];
        int answer = 0;

        // 초기화
        for(int i=0; i<2; i++) {
            Arrays.fill(dp[i], 1);
        }

        // 증가 dp 구하기
        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(arr[j] < arr[i]){
                    dp[0][i] = Math.max(dp[0][i], dp[0][j]+1);
                }
            }
        }

        // 감소 dp 구하기
        for(int i=n-1; i>=0; i--) {
            for(int j=n-1; j>i; j--) {
                if(arr[i] > arr[j]){
                    dp[1][i] = Math.max(dp[1][i], dp[1][j]+1);
                }
            }
        }

        // 가장 긴 수열 구하기
        for(int i=0; i<n; i++) {
            answer = Math.max(answer, dp[0][i] + dp[1][i] - 1);
        }
        System.out.println(answer);
    }
}
