import java.util.*;
import java.io.*;

public class Main {
    public static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        long answer = go(a, b);
        System.out.println(answer);

    }

    public static long go(int a, int b) {

        // 1번만 나눈다면
        if(b == 1) {
            return a % c;
        }

        long num = go(a, (b/2));
        num = (num * num) % c;
        // 홀수일 때 한 번 더 곱해준다
        if(b % 2 == 1) num = (num * a) % c;
        return num;
    }
}