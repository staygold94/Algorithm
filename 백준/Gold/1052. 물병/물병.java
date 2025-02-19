import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = toi(st.nextToken());
        int k = toi(st.nextToken());

        if(n <= k) {
            System.out.println(0);
            return;
        }

        int answer = 0;
        while(true) {
            int count = 0;
            int num = n;
            while(num != 0) {
                if(num % 2 == 1) count++;
                num /= 2;
            }
            if(count <= k) break;
            n++;
            answer++;
        }
        System.out.println(answer);
    }

    public static int toi(String s) {
        return Integer.parseInt(s);
    }
}
