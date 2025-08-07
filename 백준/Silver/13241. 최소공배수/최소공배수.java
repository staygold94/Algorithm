import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long num = GCD(arr[0], arr[1]);
        long answer = arr[0] * arr[1] / num;
        System.out.println(answer);
    }

    public static long GCD(long a, long b) {
        if(b == 0) return a;

        return GCD(b, a%b);
    }
}
