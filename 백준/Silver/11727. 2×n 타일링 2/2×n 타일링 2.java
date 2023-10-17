import java.io.*;

public class Main {

    static Integer[] dp;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new Integer[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        
        for(int i=3; i<=n; i++) {
            recur(i);
        }
        System.out.println(recur(n));
    }

    public static int recur(int n) {

        if(dp[n] == null) {
            dp[n] = (dp[n-2] * 2 + dp[n-1]) % 10007;
        }
        return dp[n];
    }
}
