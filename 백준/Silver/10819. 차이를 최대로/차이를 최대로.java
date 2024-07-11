import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] arr;
    public static boolean[] visited;
    public static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            visited[i] = true;
            dfs(0, 0, i);
            visited[i] = false;
        }
        System.out.println(answer);
    }

    public static void dfs(int depth, int total, int idx) {

        if(depth == n-1) {
            answer = Math.max(answer, total);
            return;
        }

        for(int i=0; i<arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth+1, total + Math.abs(arr[idx] - arr[i]), i);
                visited[i] = false;
            }
        }
    }
}