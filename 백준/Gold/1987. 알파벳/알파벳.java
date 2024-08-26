import java.io.*;
import java.util.*;

public class Main {
    public static int answer = -1;
    public static int r, c;
    public static char[][] arr;
    public static boolean[] visited = new boolean[26];
    public static int[][] moves = {{0, -1} , {0, 1},  {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];

        for(int i=0; i<r; i++) {
            String tmp = br.readLine();
            for(int j=0; j<c; j++) {
                arr[i][j] = tmp.charAt(j);
            }
        }

        visited[arr[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(answer);
    }

    public static void dfs(int x, int y, int cnt) {

        answer = Math.max(answer, cnt);

        for(int i=0; i<moves.length; i++) {
            int newX = x + moves[i][0];
            int newY = y + moves[i][1];

            // 범위 넘어가면 패스
            if(newX < 0 || newX >= r || newY < 0 || newY >= c) continue;

            // 이미 속해있으면 패스
            char ch = arr[newX][newY];
            if(visited[ch - 'A']) continue;

            visited[ch - 'A'] = true;
            dfs(newX, newY, cnt+1);
            visited[ch - 'A'] = false;
        }
    }
}