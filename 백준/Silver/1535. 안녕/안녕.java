import java.util.*;
import java.io.*;

public class Main {
    public static int n, answer;
    public static boolean[] visited;
    public static int[] power, happy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        power = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        happy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dfs(100, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int nowPower, int nowHappy, int idx) {
        
        for(int i=idx; i<n; i++) {
            if(!visited[i] && 0 < nowPower - power[i]) {
                visited[i] = true;

                nowPower -= power[i];
                nowHappy += happy[i];
                answer = Math.max(answer, nowHappy);
                dfs(nowPower, nowHappy, i+1);
                nowPower += power[i];
                nowHappy -= happy[i];

                visited[i] = false;
            }
        }
        return;
    }
}
