import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Long[][] dp = new Long[n+1][k+1];

        // 초기값 설정
        for(int i=0; i<=n; i++) {
            dp[i][0] = 0L;
        }
        for(int i=1; i<=n; i++) {
            dp[i][1] = 1L;
        }
        for(int i=1; i<=k; i++) {
            dp[0][i] = 1L;
        }

        // 점화식
        for(int i=1; i<=n; i++) {
            for(int j=2; j<=k; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000;
            }
        }

        // dp 출력
        // for(int i=0; i<=n; i++) {
        //     for(int j=0; j<=k; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(dp[n][k]);
    }
}
