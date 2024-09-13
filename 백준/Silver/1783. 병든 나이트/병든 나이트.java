import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;

        if(n == 1) {
            answer = 1;
        } else if(n == 2) {
            answer = Math.min(4, (m+1)/2);  // 최대 4칸 움직일 수 있음
        } else {
            if(m < 7) {
                answer = Math.min(4, m);    // 최대 4칸 움직일 수 있음
            } else {
                // 처음 4가지 경우에서 오른쪽으로 2칸 가는 경우 2번 제외
                answer = m - 2;
            }
        }
        System.out.println(answer);
    }
}