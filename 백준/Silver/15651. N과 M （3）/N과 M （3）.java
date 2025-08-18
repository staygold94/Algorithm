import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        backtrack(0, "");

        System.out.print(sb.toString());
    }

    public static void backtrack(int depth, String str) {

        if(depth == m) {
            sb.append(str + "\n");
            return;
        }

        for(int i=1; i<=n; i++) {
            backtrack(depth+1, str + i + " ");
        }
    }
}
