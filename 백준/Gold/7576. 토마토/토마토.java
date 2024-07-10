import java.io.*;
import java.util.*;


public class Main {
    public static int m;
    public static int n;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int cnt = 0;
    public static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        
        int total = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                // 토마토가 들어간 상자의 경우 전체 갯수++
                if(arr[i][j] != -1) {
                    total++;
                    if(arr[i][j] == 1) {
                        queue.offer(new int[] {i, j, 0});
                        visited[i][j] = true;
                        cnt++;
                    }
                }
            }
        }

        int days = bfs(queue);
        int answer = total != cnt ? -1 : days;
        System.out.println(answer);
    }

    public static int bfs(Queue<int[]> queue) {

        int days = 0;

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int depth = tmp[2];
            days = Math.max(days, depth);
            
            for(int i=0; i<moves.length; i++) {
                int nextX = x + moves[i][0];
                int nextY = y + moves[i][1];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }

                // 방문하지 않았고, 0인 경우
                if(!visited[nextX][nextY] && arr[nextX][nextY] == 0) {
                    queue.offer(new int[] {nextX, nextY, depth+1});
                    visited[nextX][nextY] = true;
                    cnt++;
                }
            }
        }
        return days;
    }
}