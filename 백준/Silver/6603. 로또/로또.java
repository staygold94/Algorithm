import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] arr;
    public static StringBuilder result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        result = new StringBuilder();
        
        while(true) {
            String s = br.readLine();

            if(s.equals("0")) break;

            StringTokenizer st = new StringTokenizer(s);
            n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0, sb);
            result.append("\n");
        }
        System.out.print(result.toString().trim());
    }

    public static void dfs(int start, int depth, StringBuilder sb) {

        if(depth == 6) {
            result.append(sb).append("\n");
            return;
        }

        for(int i=start; i<n; i++) {
            if((n - i) + depth >= 6) {
                int lenBefore = sb.length();
                sb.append(arr[i] + " ");
                dfs(i+1, depth+1, sb);
                sb.setLength(lenBefore);
            }
        }
    }
}