import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k+1];

        // 초기값
        dp[a] = 0;

        for(int i=a+1; i<=k; i++) {

            // 1 더하기
            dp[i] = dp[i-1] + 1;

            // 2 곱하기
            if(i % 2 == 0 && i / 2 >= a) dp[i] = Math.min(dp[i], dp[i/2] + 1);
        }

        System.out.println(dp[k]);
    }
}