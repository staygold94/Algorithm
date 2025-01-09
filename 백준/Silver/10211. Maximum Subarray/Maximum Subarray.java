import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] dp = new int[n];
            int max;

            // 초기값
            dp[0] = Integer.parseInt(st.nextToken());
            max = dp[0];

            for(int j=1; j<n; j++) {
                int num = Integer.parseInt(st.nextToken());
                dp[j] = Math.max(dp[j-1] + num, num);
                max = Math.max(max, dp[j]);
            }

            sb.append(max + "\n");
        }
        
        System.out.print(sb.toString());
    }
}