import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            boolean answer = true;
            String[] arr = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            for(int j=0; j<arr.length; j++) {
                String str = arr[j];
                // 스택이 비어있는데 닫는 괄호가 나온다면 false
                if(stack.isEmpty() && str.equals(")")) {
                    answer = false;
                    break;
                }
                
                if(str.equals("(")) {
                    stack.push(str);
                } else {
                    stack.pop();
                }
            }
            System.out.println(stack.size() == 0 && answer ? "YES" : "NO");
        }
    }
}