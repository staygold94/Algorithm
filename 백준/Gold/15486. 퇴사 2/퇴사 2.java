import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[2][n];
		int[] dp = new int[n];
		StringTokenizer st;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[0][i] = Integer.parseInt(st.nextToken());
			arr[1][i] = Integer.parseInt(st.nextToken());
		}
		
		// 기본
		if(arr[0][n-1] == 1) dp[n-1] = arr[1][n-1];
		
		for(int i=n-2; i>=0; i--) {
			// 상담 가능한 경우 
			if(i+arr[0][i] <= n) dp[i] = arr[1][i];
			// 더할 이전 dp가 있는 경우 
			if(i+arr[0][i] < n) dp[i] += dp[i+arr[0][i]];
			dp[i] = Math.max(dp[i], dp[i+1]);
		}
		
		int answer = 0;
		for(int i=0; i<n; i++) {
			answer = Math.max(answer,  dp[i]);
		}
		System.out.println(answer);
	}
}