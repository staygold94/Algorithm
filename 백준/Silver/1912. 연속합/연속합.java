import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new Integer[n+1];
        int answer;

        // 초기화
        dp[0] = 0;
        answer = n == 0 ? 0 : Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 0 입력한 경우를 제외하고
        if (n > 0) {
            
            for(int i=1; i<=n; i++) {
                solve(i);
            }

            for(int i=1; i<=n; i++) {
                answer = Math.max(answer, dp[i]);
            }
        }

        System.out.println(answer);

    }

    static Integer solve(int n) {

        if(dp[n] == null) {

            dp[n] = Math.max(Math.max((arr[n] + arr[n-1]), dp[n-1] + arr[n]), arr[n]);

        }

        return dp[n];
    }
}

/*

10
10 -4 3 1 5 6 -35 12 21 -1
33

10
2 1 -4 3 4 -4 6 5 -5 1
14

5
-1 -2 -3 -4 -5
-1

중요반례

input :
2
-1 0

ans :
0

 */