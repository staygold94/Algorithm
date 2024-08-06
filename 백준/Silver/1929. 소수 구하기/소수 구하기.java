import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int i=m; i<=n; i++) {
            if(isPrime(i)) sb.append(i + "\n");
        }
        if(sb.length() > 0) System.out.print(sb.toString());
    }

    public static boolean isPrime(int num) {
        
        if(num == 1) return false;

        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }

        return true;
    }
}