import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 초기값
        dp[1] = arr[1];

        for(int i=2; i<=n; i++) {

            // 기본값
            dp[i] = arr[i];
            
            for(int j=1; j<i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + dp[j]);
            }
            
        }
        System.out.println(dp[n]);
        
    }
}