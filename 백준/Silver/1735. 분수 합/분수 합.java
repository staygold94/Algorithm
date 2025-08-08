import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arrA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arrB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int a = arrA[0] * arrB[1] + arrB[0] * arrA[1]; // 분자
        int b = arrA[1] * arrB[1]; // 분모

        int gcd = GCD(a, b);
        StringBuilder sb = new StringBuilder();
        sb.append(a/gcd);
        sb.append(" ");
        sb.append(b/gcd);
        System.out.println(sb.toString());

    }
    public static int GCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        return GCD(b, a%b);
    }
}
