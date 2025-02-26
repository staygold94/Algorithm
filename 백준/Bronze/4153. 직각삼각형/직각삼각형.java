import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(arr);
            long a = arr[0];
            long b = arr[1];
            long c = arr[2];

            if(a == 0 && b == 0 && c == 0) break;

            if(a * a + b * b == c * c) sb.append("right\n");
            else sb.append("wrong\n");
        }
        System.out.print(sb.toString());
    }
}