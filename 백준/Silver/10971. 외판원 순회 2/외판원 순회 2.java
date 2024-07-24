import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] costs;
    public static boolean[] visited;
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        costs = new int[n][n];
        visited = new boolean[n];

        // 비용 입력 받기
        for(int i=0; i<n; i++) {
            costs[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 시작점이 n개이므로 각각 dfs 실행
        for(int i=0; i<n; i++) {
            visited[i] = true;
            dfs(i, i, 0, 0);
            visited[i] = false;
        }
        System.out.println(answer);
    }

    public static void dfs(int startIdx, int idx, int cost, int depth) {

        // 이미 한 번 방문했기 때문에 n-1에서 백트래킹
        if(depth == n-1) {
            // 돌아갈 길이 있다면 정답 갱신
            if(costs[idx][startIdx] != 0) {
                answer = Math.min(answer, cost + costs[idx][startIdx]);
            }
            return;
        }

        for(int i=0; i<n; i++) {
            // 방문하지 않았고, 방문이 가능한 경우
            if(!visited[i] && costs[idx][i] != 0) {
                visited[i] = true;
                dfs(startIdx, i, cost + costs[idx][i], depth + 1);
                visited[i] = false;
            }
        }
    }
}