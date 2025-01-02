import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            // 초기값
            long a = 0, b = 1, current = 0;

            if(p == 0) {
                current = 0;
            } else if(p == 1) {
                current = 1 % q;
            } else {
                for(int j=2; j<=p; j++) {
                    current = (a + b) % q;
                    a = b;
                    b = current;
    
                }
            }
            
            sb.append("Case #" + (i+1) + ": " + current + "\n");
        }
        System.out.print(sb.toString());
    }
}