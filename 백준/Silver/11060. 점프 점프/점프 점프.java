import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.fill(dp, -1);

        // 초기값
        dp[0] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while(!queue.isEmpty()) {
            int idx = queue.poll();     // 현재 칸
            int num = arr[idx];         // 움직일 수 있는 칸

            // 움직일 수 있는 칸만큼 탐색
            for(int i=idx+1; i<=Math.min(idx+num, n-1); i++) {
                // 아직 탐색되지 않은 경우
                if(dp[i] == -1) {
                    dp[i] = dp[idx] + 1;
                    queue.offer(i); // 움직일 수 있는 칸이므로 queue에 넣음
                }
            }
        }

        System.out.println(dp[n-1]);
    }
}