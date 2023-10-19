import java.io.*;

public class Main {

    static Long[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new Long[n+1][2];

        // 초기값 설정
        dp[0][0] = 0L;
        dp[0][1] = 1L;

        for(int i=1; i<n; i++) {
            for(int j=0; j<2; j++) {
                solve(i,j);
            }
        }

        // dp 프린트
        // for(int i=0; i<n; i++) {
        //     for(int j=0; j<2; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        Long answer = dp[n-1][0] + dp[n-1][1];

        System.out.println(answer);
    }

    public static Long solve(int i, int j) {

        if(j==0) {
            dp[i][j] = dp[i-1][0] + dp[i-1][1];
        } else {
            dp[i][j] = dp[i-1][0];
        }

        return dp[i][j];
    }
}


/*

이친수
1. 0으로 시작하지 않음
2. 1이 연속될 수 없음

    자릿수
    1   2   3   4   5
0   0   1   1   2   3
1   1   0   1   1   2

0은 n-1에서 dp[n-1][0] + dp[n-1][1]
1은 n-1에서 dp[n-1][0]


 */