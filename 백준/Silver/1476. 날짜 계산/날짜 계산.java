import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int earth = Integer.parseInt(st.nextToken());
        int sun = Integer.parseInt(st.nextToken());
        int moon = Integer.parseInt(st.nextToken());
        int answer = 1;
        int E = 1;
        int S = 1;
        int M = 1;

        while(!(earth == E && sun == S && moon == M)) {
            E++;
            S++;
            M++;

            if(E%16 == 0) E = 1;
            if(S%29 == 0) S = 1;
            if(M%20 == 0) M = 1;

            answer++;
        }
        System.out.println(answer);
    }
}
