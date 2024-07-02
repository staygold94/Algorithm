import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 0~9까지 총 10개의 숫자 + n-1에 대비하여 양쪽으로 한 칸씩 확보
        long[][] dp = new long[n][12];

        // 초기값 설정 (1자리인 경우 1~9씩 각 1개를 가짐)
        for(int i=2; i<=10; i++) {
            dp[0][i] = 1L;
        }

        long mod = 1000000000L;
        for(int i=1; i<n; i++) {
            for(int j=1; j<=10; j++) {
                // 값이 n인 개수 = 이전 행의 m-1 + 이전 행의 m+1 개수
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
            }
        }

        long sum = 0L;
        // 맨 마지막 n번째 때 0~9 숫자들의 갯수 더함
        for(int i=1; i<=10; i++) {
            sum += dp[n-1][i];
        }
        System.out.println(sum%mod);
    }
}
