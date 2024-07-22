import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long d = findMaxDivisor(a, b);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<d; i++) {
            sb.append("1");
        }
        System.out.println(sb.toString());
    }

    public static long findMaxDivisor(long a, long b) {

        while(b > 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}