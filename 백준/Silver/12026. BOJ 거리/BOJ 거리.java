import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("");
        int[] dp = new int[n];

        // 초기값
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1; i<n; i++) {
            String s;
            
            switch(arr[i]) {
                case "B":
                    s = "J";
                    break;
                case "O":
                    s = "B";
                    break;
                default:
                    s = "O";
                    break;
            };

            for(int j=0; j<i; j++) {
                if(arr[j].equals(s) && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + (i-j) * (i-j));
                }
            }
        }

        System.out.println(dp[n-1] == Integer.MAX_VALUE ? -1 : dp[n-1]);
    }    
}
