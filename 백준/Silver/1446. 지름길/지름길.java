import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int dist = Integer.parseInt(st.nextToken());
		int[][] ways = new int[t][3];
		int[] dp = new int[dist+1];
		
		// 지름값 입력받기 
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<3; j++) {
				ways[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
		// 그냥 이동하는 경우 기본값 세팅 
		for(int i=0; i<=dist; i++) {
			dp[i] = i;
		}
		
		// 한 칸 한 칸 넣어봅시다
		for(int i=1; i<=dist; i++) {
			dp[i] = Math.min(dp[i-1] + 1, dp[i]);
			
			for(int j=0; j<t; j++) {
				// 지름길 도착 지점이라면 
				if(ways[j][1] == i) {
					dp[i] = Math.min(dp[ways[j][0]] + ways[j][2], dp[i]);
				}
			}
		}
		
		System.out.println(dp[dist]);
	}
}