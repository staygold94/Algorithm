import java.io.*;
import java.util.*;

public class Main {
    public static int maxDivisor, minMultiple;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        findMaxDivisor(a, b);
        findMinMultiple(a, b);
        System.out.println(maxDivisor);
        System.out.println(minMultiple);
    }

    // 최대공약수 구하기
    public static void findMaxDivisor(int a, int b) {

        // 최대공약수 찾으면 값 갱신하고 리턴
        if(a == b) {
            maxDivisor = a;
            return;
        }

        findMaxDivisor(Math.max(a, b) - Math.min(a, b), Math.min(a, b));
    }

    // 최소공배수 구하기
    public static void findMinMultiple(int a, int b) {

        minMultiple = maxDivisor * (a / maxDivisor) * (b / maxDivisor);

        return;
    }
}