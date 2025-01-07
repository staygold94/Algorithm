import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        for(int i=1; i<=n ;i++) {
            dp[i] = i;  // 최악의 경우 i만큼 더함
            for(int j=0; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1); // j가 제곱수인 경우 나머지 dp[i-j*j]에 1 더함
            }
        }
        System.out.println(dp[n]);
    }
}