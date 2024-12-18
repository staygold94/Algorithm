import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 연속으로 증가하는 수열 먼저 찾기
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];
        dp1[0] = 0;
        dp2[0] = 0;
        int answer = 0;

        for(int i=1; i<=n; i++) {
            if(arr[i-1] < arr[i]) {
                dp1[i] = dp1[i-1] + 1;
                dp2[i] = 1;
            } else if(arr[i-1] == arr[i]) {
                dp1[i] = dp1[i-1] + 1;
                dp2[i] = dp2[i-1] + 1;
            } else {
                dp1[i] = 1;
                dp2[i] = dp2[i-1] + 1;
            }

            // 연속으로 증가하는 가장 큰 수 찾기
            answer = Math.max(answer, Math.max(dp1[i], dp2[i]));
        }
        System.out.println(answer);
    }
}