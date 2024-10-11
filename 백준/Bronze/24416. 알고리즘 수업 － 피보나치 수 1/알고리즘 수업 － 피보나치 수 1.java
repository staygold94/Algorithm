import java.util.*;
import java.io.*;

public class Main {
    public static int cnt = 0;
    public static int dpCnt = 0;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        fib(n);
        for(int i=1; i<=n; i++) {
            dp(i);
        }
        System.out.println(cnt + " " + dpCnt);

    }

    // 동적 프로그래밍
    public static int dp(int n) {
        if(n == 1 || n == 2) {
            dp[n] = 1;            
        } else {
            dp[n] = dp[n-1] + dp[n-2];
            dpCnt++;
        }
        return dp[n];
    }

    // 재귀호출
    public static int fib(int n) {
        if (n == 1 || n == 2) {
            cnt++;
            return 1;
        } else {
            return (fib(n - 1) + fib(n - 2));
        }
    }

}