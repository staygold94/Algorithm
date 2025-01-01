import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] idx = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 초기값
        idx[0] = 0;
        dp[0] = 0;
        int answer = 0;

        for(int i=1; i<n; i++) {
            // 더 작은 값이면 인덱스값 갱신
            if(arr[idx[i-1]] > arr[i]) {
                idx[i] = i;
                dp[i] = 0;
            } else {
                idx[i] = idx[i-1];
                dp[i] = arr[i] - arr[idx[i-1]];
            }
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}