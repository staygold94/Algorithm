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

        StringTokenizer st;

        for(int i=1; i<=n; i++) {

            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 초기화
        dp[0] = 0;
        dp[1] = arr[1];

        if(n>=2) {
            dp[2] = arr[1] + arr[2];    
        }
        

        for(int i=3; i<=n; i++) {
            solve(i);
        }

        // 무조건 마지막 계단을 밟아야 하므로, max 값을 구하는 게 아니다! 함정 주의!
        System.out.println(dp[n]);
    }

    static Integer solve(int n) {

        if(dp[n] == null) {

            dp[n] = Math.max(arr[n-1] + dp[n-3], dp[n-2]) + arr[n]; 
        }

        return dp[n];
    }
}


/*

6
10
20
15
25
10
20

75
 */