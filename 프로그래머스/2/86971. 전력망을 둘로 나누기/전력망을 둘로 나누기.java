import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;  // 그래프를 표현할 ArrayList 배열
    static int min;    // 두 전력망의 송전탑 개수 차이 중 최솟값을 저장할 변수

    public int solution(int n, int[][] wires) {
        
        graph = new ArrayList[n+1]; // 노드 개수만큼 ArrayList 생성
        min = Integer.MAX_VALUE;    // 초기값을 최대값으로 설정하여 최솟값을 찾음

        // 각 노드에 대한 ArrayList 초기화
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보를 그래프에 추가
        for(int i=0; i<wires.length; i++) {
            int v1 = wires[i][0];   // 간선의 한 끝점
            int v2 = wires[i][1];   // 간선의 다른 끝점
            // 양방향 간선이므로 두 번 추가
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        // 각 간선을 하나씩 제거하면서 송전탑 개수 차이 계산
        for(int i=0; i<wires.length; i++) {
            int v1 = wires[i][0];   // 간선의 한 끝점
            int v2 = wires[i][1];   // 간선의 다른 끝점

            boolean[] visited = new boolean[n+1];   // 방문 여부를 저장할 배열 초기화

            // 해당 간선을 그래프에서 제거
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));

            // 임의의 시작점에서 DFS 탐색하여 송전탑 개수 계산
            int cnt = dfs(1, visited);
            
            // 두 전력망의 송전탑 개수 차이 계산
            int diff = Math.abs(cnt - (n - cnt));
            // 최솟값 갱신
            min = Math.min(min, diff);

            // 제거한 간선을 다시 그래프에 추가하여 다음 간선 제거를 위해 복구
            graph[v1].add(v2);
            graph[v2].add(v1);

        }

        return min; // 최솟값 반환
    }

    // DFS를 통해 송전탑 개수 계산
    static int dfs(int v, boolean[] visited) {
        visited[v] = true;  // 현재 노드 방문 처리
        int cnt = 1;    // 현재 노드 포함하여 송전탑 개수 1개로 초기화

        // 현재 노드와 인접한 노드들에 대해 DFS 재귀 호출
        for(int next:graph[v]) {
            if(!visited[next]) {
                cnt += dfs(next, visited);
            }
        }

        return cnt;
    }
}