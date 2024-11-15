import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(queue.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(queue.poll() + "\n");
                }
            } else {
                queue.offer(num);
            }
        }
        System.out.print(sb.toString());
    }
}