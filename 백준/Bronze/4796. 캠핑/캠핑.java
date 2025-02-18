import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int idx = 1;

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(l == 0 && p == 0 && v == 0) break;

            int sum = 0;
            sum += (v / p) * l;
            sum += Math.min(l, v % p);
            sb.append("Case " + idx + ": " + sum + "\n");
            idx++;
        }
        System.out.print(sb.toString());
    }
}