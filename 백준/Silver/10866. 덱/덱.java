import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch(str) {
                case "push_front":
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(!deque.isEmpty()) System.out.println(deque.pollFirst());
                    else System.out.println(-1);
                    break;
                case "pop_back":
                    if(!deque.isEmpty()) System.out.println(deque.pollLast());
                    else System.out.println(-1);
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if(deque.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front":
                    if(!deque.isEmpty()) System.out.println(deque.peekFirst());
                    else System.out.println(-1);
                    break;
                case "back":
                    if(!deque.isEmpty()) System.out.println(deque.peekLast());
                    else System.out.println(-1);
                    break;
            }
        }
    }
}