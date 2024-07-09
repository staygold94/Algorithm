import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    list.add(bfs(i, j));
                }
            }
        }

        // 오름차순 정렬
        Collections.sort(list);

        // 총 단지 수와 오름차순 정렬
        System.out.println(list.size());
        for(int i : list) {
            System.out.println(i);
        }
    }

    public static int bfs(int x, int y) {

        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        cnt++;

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();

            for(int i=0; i<moves.length; i++) {
                int nextX = tmp[0] + moves[i][0];
                int nextY = tmp[1] + moves[i][1];

                if(nextX < 0 || nextX > n-1 || nextY < 0 || nextY > n-1) {
                    continue;
                }

                if(!visited[nextX][nextY] && arr[nextX][nextY] == 1) {
                    queue.add(new int[] {nextX, nextY});
                    visited[nextX][nextY] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}