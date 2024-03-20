import java.util.*;

class Solution {
    static int[][] distances; // 시작 정점으로부터 최단 거리를 저장할 배열
    public int solution(int[][] maps) {

        // x축과 y축
        int xSize = maps.length;
        int ySize = maps[0].length;

        // 최단거리 저장 배열 초기화
        distances = new int[xSize][ySize];
        distances[0][0] = 1;

        // 큐 생성
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});

        while(!queue.isEmpty()) {
            int[] currentNode = queue.poll();

            // 도착 노드인 경우 종료
            if(currentNode[0] == xSize-1 && currentNode[1] == ySize-1) {
                return distances[currentNode[0]][currentNode[1]];
            }

            // 상하좌우 인접 노드를 탐색
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for(int[] dir : directions) {
                int nextX = currentNode[0] + dir[0];
                int nextY = currentNode[1] + dir[1];

                // 그래프 범위 넘어갈시 continue 처리
                if(nextX < 0 || nextX >= xSize || nextY < 0 || nextY >= ySize) continue;

                // 아직 방문하지 않았고 벽이 아닌 경우 접근
                if(distances[nextX][nextY] == 0 && maps[nextX][nextY] == 1) {
                    queue.offer(new int[] {nextX, nextY});
                    distances[nextX][nextY] = distances[currentNode[0]][currentNode[1]] + 1;
                }
            }
        }

        return -1;
    }
}