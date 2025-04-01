import java.util.*;
import java.io.*;

public class Main {
    public static int n, k;
    public static HashSet<String> set;
    public static int[] arr;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        arr = new int[n];
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, "");
        System.out.println(set.size());
    }

    public static void dfs(int depth, String s) {
        if(depth == k) {
            set.add(s);
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth+1, s + arr[i]);
                visited[i] = false;
            }
        }
    }
}