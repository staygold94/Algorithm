import java.io.*;

public class Main {

    static Long[][] dp; // 자릿수가 100까지 될 수 있으므로 Long으로 선언
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new Long[n+1][10];

        // 첫째자리 초기화
        for(int i=0; i<10; i++) {
            if(i==0) {
                dp[0][i] = 0L;
            } else {
                dp[0][i] = 1L;
            }
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<10; j++) {
                solve(i,j);
            }
        }

        // 2차원 배열 프린트 (n이 높아질수록 값이 달라지는지 확인하기)
        // for(int i=0; i<n; i++) {
        //     for(int j=0; j<10; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // 정답도 Long으로 선언
        Long answer = 0L;

        // n 자리의 계단수 합
        for(int i=0; i<10; i++) {
            answer += dp[n-1][i];  // answer에도 나누기 해주기
        }

        System.out.println(answer % 1000000000);

    }

    public static Long solve(int i, int j) {
        if(j==0) {
            dp[i][j] = dp[i-1][1] % 1000000000;
        } else if(j==9) {
            dp[i][j] = dp[i-1][8] % 1000000000;
        } else {
            dp[i][j] = ((dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000);    // 괄호 실수 주의하기
        }
        return dp[i][j];
    }
}
