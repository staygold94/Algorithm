import java.io.*;

public class Main {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n+1];  // 각 인덱스 별로 숫자당 몇번이 필요한지 저장
        dp[0] = dp[1] = 0;

        for(int i=2; i<=n; i++) {
            recur(i);
        }

        System.out.println(recur(n));
    }

    // Top-down 방식의 재귀호출
    static int recur(int n) {
        if(dp[n] == null) {
            if(n % 6 == 0) {
                dp[n] = Math.min(recur(n-1), Math.min(recur(n/3), recur(n/2))) + 1;
            } else if(n % 3 == 0) {
                dp[n] = Math.min(recur(n-1), recur(n/3)) + 1;
            } else if(n % 2 == 0) {
                dp[n] = Math.min(recur(n-1), recur(n/2)) + 1;
            } else {
                dp[n] = recur(n-1) + 1;
            }
        }
        return dp[n];
    }
}
