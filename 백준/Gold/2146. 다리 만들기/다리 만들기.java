import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int answer = Integer.MAX_VALUE;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬에 대해서 라벨링 작업
        int labelId = 2;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                // 육지이며 방문하지 않았다면
                if(arr[i][j] == 1 && !visited[i][j]) {
                    label(i, j, labelId);
                    labelId++;
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                // 육지이며 방문하지 않았다면
                if(arr[i][j] > 1) {
                    visited = new boolean[n][n];    // 내부에서 초기화 하기
                    bfs(i, j, arr[i][j]);
                }
            }
        }
        System.out.println(answer);
    }

    public static void label(int x, int y, int labelId) {

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {x, y});
        arr[x][y] = labelId;
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int tmpX = tmp[0];
            int tmpY = tmp[1];
            
            for(int[] move : moves) {
                int newX = tmpX + move[0];
                int newY = tmpY + move[1];

                if(newX < 0 || newX >= n || newY < 0 || newY >= n) continue;

                if(!visited[newX][newY] && arr[newX][newY] == 1) {
                    queue.offer(new int[] {newX, newY});
                    arr[newX][newY] = labelId;
                    visited[newX][newY] = true;
                }
            }
        }
    }

    public static void bfs(int x, int y, int labelId) {

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {x, y, 0});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int tmpX = tmp[0];
            int tmpY = tmp[1];
            int dist = tmp[2];
            
            for(int[] move : moves) {
                int newX = tmpX + move[0];
                int newY = tmpY + move[1];

                if(newX < 0 || newX >= n || newY < 0 || newY >= n || labelId == arr[newX][newY]) continue;

                if(!visited[newX][newY]) {
                    visited[newX][newY] = true;
                    // 바다라면 0 -> +1
                    if(arr[newX][newY] == 0) {
                        queue.offer(new int[] {newX, newY, dist+1});
                    } else {
                        // 다른 섬이라면
                        if(arr[newX][newY] != labelId) {
                            answer = Math.min(answer, dist);
                            break;
                        }
                    }
                }
            }
        }
    }

    public static boolean isEdge(int x, int y) {
        
        for(int[] move : moves) {
            int newX = x + move[0];
            int newY = y + move[1];

            if(newX >= 0 && newX < n && newY >= 0 && newY < n) {
                if(arr[newX][newY] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}