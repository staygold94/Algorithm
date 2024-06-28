import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        // 그래프 연결을 담을 graph
        List<List<Integer>> graph = new ArrayList<>();

        // 기본 전선 세팅
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        // 연결된 전선 list에 add
        for(int i=0; i<wires.length; i++) {
            graph.get(wires[i][0]).add(wires[i][1]);
            graph.get(wires[i][1]).add(wires[i][0]);
        }

        // 하나씩 제거해보며 차이가 가장 적은 네트워크 수를 구해보자
        for(int[] wire : wires) {
            int node1 = wire[0];
            int node2 = wire[1];

            // 간선 제거
            graph.get(node1).remove((Integer)node2);
            graph.get(node2).remove((Integer)node1);

            int netCnt = bfs(graph, n, node1);
            int anotherCnt = n - netCnt;

            answer = Math.min(answer, Math.abs(netCnt - anotherCnt));

            // 간선 복구
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        return answer;
    }

    public int bfs(List<List<Integer>> graph, int n, int startIdx) {

        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        queue.offer(startIdx);
        visited[startIdx] = true;
        
        while(!queue.isEmpty()) {
            // 방문처리하고 네트워크수 추가
            int num = queue.poll();
            cnt++;
            
            for(int node : graph.get(num)) {
                if(!visited[node]) {
                    queue.offer(node);
                    visited[node] = true;
                }
            }
        }

        return cnt;
    }
}
