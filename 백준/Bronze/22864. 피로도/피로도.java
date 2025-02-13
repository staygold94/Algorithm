import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int now = 0;
        int total = 0;

        for(int i=0; i<24; i++) {
            // 번아웃 오지 않을 거 같으면
            if(now + a <= d) {
                total += b;
                now += a;
            } else {
                now -= c;
                now = Math.max(now, 0);
            }
        }
        System.out.println(total);
    }
}