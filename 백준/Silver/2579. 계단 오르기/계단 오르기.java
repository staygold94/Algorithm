import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        String[] test = {"10", "20", "15", "25", "10", "20"};

        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // dp 초기값 설정
        dp[0] = arr[0];
        if(n>=1) dp[1] = arr[1];
        if(n>=2) dp[2] = arr[1] + arr[2];

        for(int i=3; i<=n; i++) {
            dp[i] = Math.max(arr[i] + arr[i-1] + dp[i-3], arr[i] + dp[i-2]);
        }
        System.out.println(dp[n]);
    }
}