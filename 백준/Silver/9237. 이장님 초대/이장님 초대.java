import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 초기값
        dp[n-1] = arr[n-1];

        for(int i=n-2; i>=0; i--) {
            dp[i] = Math.max(dp[i+1] - 1, arr[i]);
        }
        System.out.println(dp[0] + n + 1);
    }
}