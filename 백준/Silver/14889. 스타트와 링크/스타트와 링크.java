import java.util.*;
import java.io.*;

public class Main {
    public static int n, answer;
    public static boolean[] visited;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];
        answer = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int depth, int idx) {

        if(depth == n/2) {
            answer = Math.min(answer, getAnswer());
            return;
        }


        for(int i=idx; i<n; i++) {
            
            visited[i] = true;
            dfs(depth+1, i+1);
            visited[i] = false;
        }
    }

    public static int getAnswer() {

        int start = 0;
        int link = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j) continue;
                if(visited[i] && visited[j]) start += arr[i][j];
                if(!visited[i] && !visited[j]) link += arr[i][j];
            }
        }
        return Math.abs(start - link);
    }
}