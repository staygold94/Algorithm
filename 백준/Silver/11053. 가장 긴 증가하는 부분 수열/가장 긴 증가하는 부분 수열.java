import java.io.*;
import java.util.*;

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

        int max = dp[0];
		// 최댓값 찾기 
		for(int i = 1; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
        
    }

    static int solve(int n) {

        // # 탐색하지 않은 경우에만 for문을 타도록!!
        if(dp[n] == null) {
            dp[n] = 1;  // 초기화
        

            for(int i=n-1; i>=0; i--) {
                if(arr[i] < arr[n]) {
                    // # 재귀를 활용하는 게 포인트
                    dp[n] = Math.max(dp[n], solve(i) + 1);
                }
            }
        }
        
        return dp[n];
    }
    
}


/*

각 dp[] 의 길이들은 다음 부분 수열을 의미하는 것이다.
# 이와 같이 dp에 무엇을 넣을지가 중요했다. 

dp[0] = {10} : 길이 1
dp[1] = {10, 20} : 길이 2
dp[2] = {10} : 길이 1
dp[3] = {10, 20, 30} : 길이 3
dp[4] = {10, 20} : 길이 2
dp[5] = {10, 20, 30, 50} : 길이 4

6
10 20 10 30 20 50
answer 4

7
70 30 50 60 70 0 10
answer 4

8
10 50 60 70 20 30 40 50
answer 5

 */