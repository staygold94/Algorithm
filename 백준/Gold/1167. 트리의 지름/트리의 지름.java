import java.io.*;
import java.util.*;

public class Main {
    public static HashMap<Integer, Integer>[] list;
    public static int dist = 0;
    public static int idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new HashMap[n+1];

        // 해시맵 리스트 초기화
        for(int i=0; i<=n; i++) {
            list[i] = new HashMap<>();
        }

        for(int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            while(true) {
                int tmp = Integer.parseInt(st.nextToken());
                // -1 인 경우 break
                if(tmp == -1) break;

                // 관계된 정점에 대해 거리 저장
                int distance = Integer.parseInt(st.nextToken());
                list[num].put(tmp, distance);
            }
        }

        // 임의의 노드 1에서 출발하여 가장 먼 노드 찾기
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        dfs(1, 0, visited);

        // 가장 먼 노드에서 가장 먼 노드 찾기
        visited = new boolean[n+1];
        visited[idx] = true;
        dist = 0;
        dfs(idx, 0, visited);

        System.out.println(dist);
    }

    public static void dfs(int start, int distance, boolean[] visited) {

        // 정답 갱신
        if(distance > dist) {
            dist = distance;
            idx = start;
        }

        for(int i : list[start].keySet()) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, distance + list[start].get(i), visited);
            }
        }
    }
}