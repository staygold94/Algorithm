import java.io.*;
import java.util.*;

public class Main {
    public static int F, S, G, U, D, answer;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());   // 총 F층 있고,
        S = Integer.parseInt(st.nextToken());   // 현재 S층 이며,
        G = Integer.parseInt(st.nextToken());   // G층에 가고 싶음
        U = Integer.parseInt(st.nextToken());   // 위로 U층 올라갈 수 있고,
        D = Integer.parseInt(st.nextToken());   // 아래로 D층 내려갈 수 있음

        // 방문처리를 위한 배열 초기화
        visited = new boolean[F+1];

        // 정답 초기화 (0인 경우 움직일 수 없는 것)
        answer = Integer.MAX_VALUE;
        
        // dfs는 재귀가 깊어질 수 있으므로 bfs로 접근
        bfs();

        // 정답 출력
        System.out.println(answer == Integer.MAX_VALUE ? "use the stairs" : answer);
    }

    public static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        visited[S] = true;
        queue.offer(new int[] {S, 0});

        while(!queue.isEmpty()) {

            int[] now = queue.poll();

            // 목적지 도착시
            if(now[0] == G) {
                answer = now[1];
                break;    
            }

            // 위아래로 이동
            int newU = now[0] + U;
            int newD = now[0] - D;

            if(newU <= F && !visited[newU]) {
                visited[newU] = true;
                queue.offer(new int[] {newU, now[1]+1});
            }
            if(newD > 0 && !visited[newD]) {
                visited[newD] = true;
                queue.offer(new int[] {newD, now[1]+1});
            }
        }        
    }
}