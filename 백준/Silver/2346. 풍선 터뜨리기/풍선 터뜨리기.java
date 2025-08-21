import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            queue.offer(i);
        }

        // 초기값은 1번
        int move = arr[queue.pollFirst()];
        sb.append(1 + " ");

        while(!queue.isEmpty()) {
            // 양수일 때 move-1만큼 움직여야 터트릴 풍선이 맨앞에 옴
            if(move > 0) {
                for(int i=0; i<move-1; i++) {
                    queue.offerLast(queue.pollFirst());
                }
            // 음수일 때 Math.abs(move)만큼 움직여야 터트릴 풍선이 맨앞에 옴
            } else {
                for(int i=0; i<Math.abs(move); i++) {
                    queue.offerFirst(queue.pollLast());
                }
            }

            // 맨앞에 온 요소를 뽑는다
            int tmp = queue.pollFirst();
            sb.append(tmp + " ");
            move = arr[tmp];
        }
        System.out.println(sb.toString());
    }
}
