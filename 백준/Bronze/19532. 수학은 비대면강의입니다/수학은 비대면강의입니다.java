import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a1 = arr[0];
        int b1 = arr[1];
        int c1 = arr[2];
        int a2 = arr[3];
        int b2 = arr[4];
        int c2 = arr[5];

        // 소거법
        int d = a1 * b2 - a2 * b1;
        if(d == 0) {
            System.out.println("동일하거나 평행한 선입니다.");
        }
        int x = (b2*c1 - b1*c2) / d;
        int y = (a2*c1 - a1*c2) / -d;
        System.out.println(x);
        System.out.println(y);
    }
}