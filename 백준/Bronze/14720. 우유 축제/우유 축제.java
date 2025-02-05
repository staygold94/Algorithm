import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int need = 0;
        int answer = 0;
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num == need) {
                answer++;
                need = (need + 1) % 3;
            }
        }
        System.out.println(answer);
    }
}