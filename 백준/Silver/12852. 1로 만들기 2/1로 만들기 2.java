import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int[] prev = new int[n+1];

        // 초기값
        dp[1] = 0;
        
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + 1;
            prev[i] = i-1;

            if(i % 3 == 0 && dp[i/3] < dp[i]) {
                dp[i] = dp[i/3] + 1;
                prev[i] = i/3;
            }

            if(i % 2 == 0 && dp[i/2] < dp[i]) {
                dp[i] = dp[i/2] + 1;
                prev[i] = i/2;
            }
        }

        StringBuilder sb = new StringBuilder();
        
        for(int i=n; i!=0; i=prev[i]) {
            sb.append(i + " ");
        }
        System.out.println(dp[n]);
        System.out.println(sb.toString());
    }
}