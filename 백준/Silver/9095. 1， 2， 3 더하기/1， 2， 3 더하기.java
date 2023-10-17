import java.io.*;

public class Main {
    static Integer[] dp;
    
    public static void main(String[] args) throws IOException {

        dp = new Integer[11];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int su = Integer.parseInt(br.readLine());   // 테스트 케이스

        // 테스트 케이스만큼 반복
        for(int j=0; j<su; j++) {
            int n = Integer.parseInt(br.readLine());

            for(int i=4; i<=n; i++) {
                recur(i);
            }
            System.out.println(recur(n));
        }
    }

    // 점화식을 알아차리는 게 dp 문제에서 핵심이지 않을까..
    public static int recur(int n) {
        if(dp[n] == null) {
            dp[n] = dp[n-3] + dp[n-2] + dp[n-1];
        }
        return dp[n];
    }
}
