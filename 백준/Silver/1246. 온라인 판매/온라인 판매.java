import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[m];
        long[] dp = new long[m];

        for(int i=0; i<m; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long price = 0;
        long answer = 0;
        for(int i=0; i<m; i++) {
            dp[i] = arr[m - i -1] * (Math.min(i+1, n));
            if(answer < dp[i]) {
                price = arr[m - i - 1];
                answer = dp[i];
            }
        }
        System.out.println(price + " " + answer);
    } 
}