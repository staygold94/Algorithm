import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int idx;
    int cost;

    public Node(int idx, int cost) {
        this.idx = idx;
        this.cost = cost;
    }

    // 우선순위 큐에서 비용이 적게 드는 것부터 정렬하기 위해 오버라이딩
    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int startPoint = Integer.parseInt(br.readLine()) - 1;

        // 정점 크기만큼 리스트 배열 생성
        List<Node>[] graph = new ArrayList[v];
        for(int i=0; i<v; i++) {
            graph[i] = new ArrayList<>();   // 리스트 초기화
        }

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int worth = Integer.parseInt(st.nextToken());
            // 각 정점에 대한 목적지와 가중치 리스트에 추가
            graph[start].add(new Node(end, worth));
        }

        // 거리 배열 및 방문 배열 선언
        int[] dist = new int[v];
        boolean[] visited = new boolean[v];
        int INF = Integer.MAX_VALUE;
        PriorityQueue<Node> queue = new PriorityQueue<>();

        // 거리 배열 초기화
        Arrays.fill(dist, INF);

        // 시작점 큐에 담기
        queue.offer(new Node(startPoint, 0));
        dist[startPoint] = 0;

        while(!queue.isEmpty()) {
            int index = queue.poll().idx;
            visited[index] = true;

            for(Node next : graph[index]) {
                if(!visited[next.idx] && dist[next.idx] > dist[index] + next.cost) {
                    dist[next.idx] = dist[index] + next.cost;
                    queue.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        for(int i=0; i<v; i++) {
            System.out.println(dist[i] == INF ? "INF" : dist[i]);
        }
    }
}