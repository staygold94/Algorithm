import java.io.*;

public class Main {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new Integer[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        // 재귀의 depth가 깊어지는 걸 막기 위해 미리 실행
        for(int i=3; i<=n; i++) {
            recur(i);
        }

        System.out.println(recur(n));
    }

    // 재귀함수 (top-down 방식)
    public static int recur(int n) {
        if(dp[n] == null && n>=3) {
            dp[n] = (dp[n-2] + dp[n-1]) % 10007;
        }
        return dp[n];
    }
}
