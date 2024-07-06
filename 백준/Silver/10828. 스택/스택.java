import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                String command = st.nextToken();
                switch(command) {
                    case "push":
                        int num = Integer.parseInt(st.nextToken());
                        stack.push(num);
                        break;
                    case "pop":
                        if(!stack.isEmpty()) {
                            System.out.println(stack.pop());
                        } else {
                            System.out.println(-1);
                        }
                        break;
                    case "size":
                        System.out.println(stack.size());
                        break;
                    case "empty":
                        System.out.println(stack.isEmpty() ? 1 : 0);
                        break;
                    case "top":
                        if(!stack.isEmpty()) {
                            System.out.println(stack.peek());
                        } else {
                            System.out.println(-1);
                        }
                        break;
                    default:
                }
            }
        }
    }
}
