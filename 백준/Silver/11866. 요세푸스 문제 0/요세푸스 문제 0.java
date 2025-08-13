import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            queue.offer(i);
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!queue.isEmpty()) {
            cnt++;
            int tmp = queue.poll();

            if(cnt % m == 0) {
                if(queue.isEmpty()) sb.append(tmp);
                else sb.append(tmp + ", ");
            } else {
                queue.offer(tmp);
            }
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
}
