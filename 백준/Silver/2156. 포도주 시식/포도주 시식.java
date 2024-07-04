import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n+1];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[0];
        if(n >= 2) dp[2] = dp[1] + arr[1];

        for(int i=3; i<=n; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i-1], dp[i-3] + arr[i-1] + arr[i-2]));
        }

        System.out.println(dp[n]);
    }
}
