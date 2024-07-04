import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n];
        int answer = 0;

        // 초기화
        for(int i=0; i<n; i++) {
            dp[i] = arr[i];
        }

        // 증가값이라면 더하기
        for(int i=0; i<n; i++) {
            int max = 0;
            for(int j=0; j<i; j++) {
                if(arr[j] < arr[i]) { 
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] += max;
            if(answer < dp[i]) answer = dp[i];
        }
        System.out.println(answer);
    }
}
