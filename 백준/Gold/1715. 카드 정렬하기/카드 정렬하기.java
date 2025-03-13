import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for(int i=0; i<n; i++) {
            que.offer(Integer.parseInt(br.readLine()));
        }

        long answer = 0;
        while(que.size() > 1) {
            int tmp = que.poll() + que.poll();
            answer += tmp;
            que.offer(tmp);
        }

        System.out.println(answer);
    }
}