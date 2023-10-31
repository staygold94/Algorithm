import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++) {
            solve(i);
        }

        // dp의 값중 가장 큰 값을 찾아 출력
        int answer = 0;

        for(int i=0; i<n; i++) {
            answer = Math.max(answer, dp[i]);
            // System.out.print(dp[i] + " ");
        }

        System.out.println(answer);
    }

    static Integer solve(int n) {

        // 빈값에 대해서만 재귀 호출
        if(dp[n] == null) {

            dp[n] = arr[n];  // 초기화

            for(int i=n-1; i>=0; i--) {
                if(arr[i] < arr[n]) {
                    dp[n] = Math.max(dp[n], solve(i) + arr[n]);
                }
            }
        }

        return dp[n];
    }
}


/*

10
1 100 2 50 60 3 5 6 7 8
answer 113 (1 + 2 + 50 + 60 )

5
100 1 3 5 7
answer 100

6
100 200 110 320 190 210
answer 620

 */