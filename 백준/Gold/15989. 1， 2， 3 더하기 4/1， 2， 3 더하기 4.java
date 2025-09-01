import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[10000][3];
		
		dp[0][0] = dp[1][0] = dp[1][1] = dp[2][0] = dp[2][1] = dp[2][2] = 1;
		
		// dp[i][0,1,2]는 각각 1,2,3으로 끝난다고 생각하면 된다.
		// 1은 한 칸 위로 올라가 1 부분 값에 1을 더한다 생각하고 가져온다. 
		// 2는 두 칸 위로 올라가 1, 2 부분 값에 2를 더한다 생각하고 가져온다.
		// 3은 세 칸 위로 올라가 1, 2, 3 부분 값에 3을 더한다 생각하고 가져온다. 
		for(int i=3; i<10000; i++) {
			dp[i][0] = dp[i-1][0];
			dp[i][1] = dp[i-2][0] + dp[i-2][1];
			dp[i][2] = dp[i-3][0] + dp[i-3][1] + dp[i-3][2];
		}
		
		for(int j=0; j<t; j++) {
			int n = Integer.parseInt(br.readLine());
			int answer = dp[n-1][0] + dp[n-1][1] + dp[n-1][2];
			System.out.println(answer);
		}
	}
}