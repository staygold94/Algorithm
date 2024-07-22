import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = findMaxDivisor(a, b);
            System.out.println(a * b / d);
        }
    }

    public static int findMaxDivisor(int a, int b) {

        int x = Math.max(a, b);
        int y = Math.min(a, b);

        while(y != 0) {
            int r = x % y;
            x = y;
            y = r; 
        }
        return x;
    }
}