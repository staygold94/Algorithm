import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int idx = 0;

        while(!queue.isEmpty()) {
            int num = queue.poll();
            idx++;

            if(idx % k != 0) {
                queue.offer(num);
            } else {
                sb.append(num + ", ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append(">");
        System.out.println(sb.toString());
    }
}