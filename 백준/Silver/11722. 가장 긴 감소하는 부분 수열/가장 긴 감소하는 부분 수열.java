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

        dp[0] = 1;

        for(int i=0; i<n; i++) {
            solve(i);
        }

        int answer = dp[0];

        for(int i=1; i<n; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    
    }

    static Integer solve(int n) {

        if(dp[n] == null) {

            dp[n] = 1;

            for(int i=n-1; i>=0; i--) {
                if(arr[i] > arr[n]) {
                    dp[n] = Math.max(dp[n], solve(i) + 1);
                }
            }
        }

        return dp[n];
    }
}


/*

6
10 30 10 20 20 10
answer 3

5
100 90 100 70 50
answer 4

8
1 30 2 27 10 8 6 9


 */