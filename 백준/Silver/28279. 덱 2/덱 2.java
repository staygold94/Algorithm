import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            switch(num) {
                case 1:
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    deque.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    if(deque.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.pollFirst() + "\n");
                    }
                    break;
                case 4:
                    if(deque.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.pollLast() + "\n");
                    }
                    break;
                case 5:
                    sb.append(deque.size() + "\n");
                    break;
                case 6:
                    if(deque.isEmpty()) {
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                    break;
                case 7:
                    if(deque.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.peekFirst() + "\n");
                    }
                    break;
                case 8:
                    if(deque.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(deque.peekLast() + "\n");
                    }
                    break;
            }
        }

        System.out.print(sb.toString());
    }
}
