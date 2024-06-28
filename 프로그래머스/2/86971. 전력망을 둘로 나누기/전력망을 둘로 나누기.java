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

            int netCnt = dfs(graph, node1, new boolean[n+1]);
            int anotherCnt = n - netCnt;

            answer = Math.min(answer, Math.abs(netCnt - anotherCnt));

            // 간선 복구
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        return answer;
    }

    public int dfs(List<List<Integer>> graph, int startIdx, boolean[] visited) {

        int cnt = 0;
        
        // 현재 노드에 대한 방문처리, cnt 증가
        visited[startIdx] = true;
        cnt++;
        
        for(int node : graph.get(startIdx)) {
            if(!visited[node]) {
                cnt += dfs(graph, node, visited);
            }
        }

        return cnt;
    }
}
