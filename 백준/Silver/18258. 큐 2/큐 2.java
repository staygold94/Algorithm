import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            switch(s) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    queue.offerLast(num);
                    break;
                case "pop":
                    if(!queue.isEmpty()) sb.append(queue.pollFirst() + "\n");
                    else sb.append("-1\n");
                    break;
                case "size":
                    sb.append(queue.size() + "\n");
                    break;
                case "empty":
                    if(queue.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "front":
                    if(!queue.isEmpty()) sb.append(queue.peekFirst() + "\n");
                    else sb.append("-1\n");
                    break;
                case "back":
                    if(!queue.isEmpty()) sb.append(queue.peekLast() + "\n");
                    else sb.append("-1\n");
                    break;    
            }
        }
        System.out.print(sb.toString());
    }
}