import java.io.*;
import java.util.*;

class loc {
    int x;
    int y;

    public loc(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n;
    public static int m;
    public static int[][] arr;
    public static int[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        result = new int[n][m];

        // 배열 입력
        for(int i=0; i<n; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        // -1로 미방문처리
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                result[i][j] = -1;
            }
        }

        bfs();
        System.out.println(result[n-1][m-1]);
    }

    public static void bfs() {

        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<loc> queue = new LinkedList<>();
        queue.offer(new loc(0, 0));
        result[0][0] = 1;

        while(!queue.isEmpty()) {
            loc tmp = queue.poll();

            for(int i=0; i<moves.length; i++) {
                int nextX = tmp.x + moves[i][0];
                int nextY = tmp.y + moves[i][1];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }

                // 길이 있고 미방문한 경우
                if(arr[nextX][nextY] == 1 && result[nextX][nextY] == -1) {
                    queue.offer(new loc(nextX, nextY));
                    result[nextX][nextY] = result[tmp.x][tmp.y] + 1;
                }
            }
        }
    }
}