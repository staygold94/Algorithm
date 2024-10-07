import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        int[][] dp = new int[n][3];

        for(int i=0; i<n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            for(int j=0; j<3; j++) {
                dp[i][j] = arr[i][j];
                if(i > 0) dp[i][j] += Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]);
                if(i == n-1) {
                    answer = Math.min(answer, dp[i][j]);
                }
            }
        }
        System.out.println(answer);
    }
}