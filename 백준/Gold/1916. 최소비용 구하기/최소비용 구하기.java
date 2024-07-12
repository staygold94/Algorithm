import java.io.*;
import java.util.*;

class Bus implements Comparable<Bus> {
    int index;
    int worth;

    public Bus(int index, int worth) {
        this.index = index;
        this.worth = worth;
    }

    @Override
    public int compareTo(Bus o) {
        return Integer.compare(this.worth, o.worth);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());    // 도시의 개수
        int m = Integer.parseInt(br.readLine());    // 버스의 개수
        List<Bus>[] graph = new ArrayList[n];
        int[] dist = new int[n];
        int INF = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n];
        PriorityQueue<Bus> queue = new PriorityQueue<>();

        // 간선 배열 초기화
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 최소 거리 배열 초기화
        for(int i=0; i<n; i++) {
            dist[i] = INF;
        }

        // 간선 관계 갱신
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Bus(e, w));
        }

        // 시작점, 도착점 받기
        st = new StringTokenizer(br.readLine());
        int startPoint = Integer.parseInt(st.nextToken()) - 1;
        int endPoint = Integer.parseInt(st.nextToken()) - 1;

        // 시작점 초기 세팅
        queue.offer(new Bus(startPoint, 0));
        dist[startPoint] = 0;

        // 다익스트라 알고리즘 풀기
        while(!queue.isEmpty()) {
            int idx = queue.poll().index;

            if(idx == endPoint) {
                break;
            }
            visited[idx] = true;

            for(Bus bus : graph[idx]) {
                if(!visited[bus.index] && dist[bus.index] > dist[idx] + bus.worth) {
                    dist[bus.index] = dist[idx] + bus.worth;
                    queue.offer(new Bus(bus.index, dist[bus.index]));
                }
            }
        }
        System.out.println(dist[endPoint]);
    }
}