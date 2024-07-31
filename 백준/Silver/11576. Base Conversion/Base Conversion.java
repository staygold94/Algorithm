import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int sum = 0;

        for(int i=m-1; i>=0; i--) {
            int n = Integer.parseInt(st.nextToken());
            sum += Math.pow(a, i) * n;
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        if(sum == 0) {
            stack.add(0);
        }

        while(sum > 0) {
            stack.add(sum % b);
            sum /= b;
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString());
    }
}