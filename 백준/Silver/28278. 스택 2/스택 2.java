import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            switch(num){
                case 1:
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    if(!stack.isEmpty()) sb.append(stack.pop() + "\n");
                    else sb.append("-1\n");
                    break;
                case 3:
                    sb.append(stack.size() + "\n");
                    break;
                case 4:
                    sb.append((stack.isEmpty() ? 1 : 0) + "\n");
                    break;
                case 5:
                    if(!stack.isEmpty()) sb.append(stack.peek() + "\n");
                    else sb.append("-1\n");
                    break;
            };
        }
        System.out.print(sb.toString());
    }
}