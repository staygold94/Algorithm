import java.util.*;

class Solution {
    /*
     * 각 노드에 연결된 다른 노드들을 리스트로 관리한다. 이것은 무방향 그래프에서 각 노드의 이웃을 저장하는 방법이다.
     * 각 엣지에 대해 두 개의 노드 간의 연결을 양쪽으로 기록한다.
     * 방문한 노드를 추적하여, 너비 우선 탐색을 수행한다.
     */


    // 무방향 그래프를 담을 리스트
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        
        // 리스트 내 리스트 초기화
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

        // 무방향 그래프이므로 양쪽 모두 기록해준다
        for(int[] i: edge) {
            int v = i[0];
            int w = i[1];
            graph.get(v).add(w);
            graph.get(w).add(v);
        }

        // 방문배열 선언 및 초기화
        boolean[] visit = new boolean[n+1];

        // 그래프, 시작점, 방문배열을 인자로 bfs(너비우선탐색) 진행
        return bfs(graph, n, visit);
    }

    public static int bfs(ArrayList<ArrayList<Integer>> graph, int n, boolean[] visit) {
        // 노드 + depth를 함께 들고 다니기 위해 int[]의 Queue 선언
        Queue<int[]> queue = new LinkedList<>();
        int answer = 0;
        int maxDepth = 0;

        // 현재 노드(1) + 현재 depth(0)을 큐에 넣는다
        queue.offer(new int[] {1, 0});

        // 노드 1를 방문 처리한다.
        visit[1] = true;

        // 큐에 값이 있는 동안 탐색을 계속한다
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int v = arr[0];
            int depth = arr[1];

            if(maxDepth == depth) answer++; // 최대 길이 노드라면 answer++;
            else if(maxDepth < depth) {     // 더 긴 거리에 노드가 있다면 answer = 1, maxDepth 갱신
                maxDepth = depth;
                answer = 1;
            }

            // v에 대한 ArrayList 순회
            for(int i=0; i<graph.get(v).size(); i++) {
                int w = graph.get(v).get(i);

                // 방문하지 않은 경우 스택에 쌓음 + 방문처리
                if(!visit[w]) {
                    queue.offer(new int[] {w, depth+1});
                    visit[w] = true;
                }
            }
        }
        return answer;
    }
}