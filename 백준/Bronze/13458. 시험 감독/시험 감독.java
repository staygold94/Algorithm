import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        long answer = 0;

        for(int i=0; i<n; i++) {
            int cnt = arr[i];
            
            cnt -= m;
            answer++;

            if(cnt > 0) {
                if(cnt % s == 0) {
                    answer += cnt / s;
                } else {
                    answer += (cnt / s) + 1;
                }
            }
        }
        System.out.println(answer);
    }
}