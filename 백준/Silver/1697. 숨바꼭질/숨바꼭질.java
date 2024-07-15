import java.io.*;
import java.util.*;

class move {
    int idx;
    int time;

    public move(int idx, int time) {
        this.idx = idx;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int answer = bfs(n, k , 0);
        System.out.println(answer);
    }

    public static int bfs(int n, int k, int depth) {

        int answer = 0;
        Queue<move> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        // queue 초기값
        queue.offer(new move(n, depth));
        visited[n] = true;

        // 최단경로를 찾기 위해 bfs로 진행
        while(!queue.isEmpty()) {
            move m = queue.poll();

            // 동생을 찾으면 해당 시간을 정답으로 지정하고 break
            if(m.idx == k) {
                answer = m.time;
                break;
            }

            if(m.idx + 1 <= 100000 && !visited[m.idx + 1]) {
                queue.offer(new move(m.idx + 1, m.time + 1));
                visited[m.idx + 1] = true;
            }
            if(m.idx - 1 >= 0 && !visited[m.idx - 1]) {
                queue.offer(new move(m.idx - 1, m.time + 1));
                visited[m.idx - 1] = true;
            }
            if(m.idx * 2 <= 100000 && !visited[m.idx * 2]) {
                queue.offer(new move(m.idx * 2, m.time + 1));
                visited[m.idx * 2] = true;
            }
        }

        return answer;
    }
}