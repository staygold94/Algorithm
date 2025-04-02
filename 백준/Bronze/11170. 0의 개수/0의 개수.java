import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for(int k=0; k<t; k++) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for(int i=n; i<=m; i++) {
                sb.append(i);
            }
            
            int total = sb.toString().length();
            int minus = sb.toString().replaceAll("0", "").length();
            answer.append((total - minus) + "\n");
        }
        System.out.print(answer.toString());
    }
}
