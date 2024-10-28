import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int answer = 1;
        v -= a;

        if(v > 0) {
            int days = v/(a-b);
            answer += v%(a-b) > 0 ? days + 1 : days;
        }
        System.out.println(answer);
    }
}