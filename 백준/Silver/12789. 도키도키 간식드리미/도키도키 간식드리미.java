import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();
        boolean isPossible = true;
        int nowNum = 1;
        int idx = 0;

        // 받을 수 있는 상황이며, 번호표의 갯수동안
        while(isPossible && idx < n) {
            
            // 현재 번호가 스택에 있는 경우
            if(!stack.isEmpty() && stack.peek() == nowNum) {
                stack.pop();
                nowNum++;

            // 현재 번호가 배열에 있는 경우
            } else if(arr[idx] == nowNum) {
                idx++;
                nowNum++;

            // 현재 번호보다 2이상 크면 스택에 넣음
            } else {
                // 이때 스택의 가장 위의 숫자보다 크면 break
                if(!stack.isEmpty() && stack.peek() < arr[idx]) {
                    isPossible = false;
                } else {
                    stack.push(arr[idx]);
                    idx++;
                }
            }
        }

        System.out.println(isPossible ? "Nice" : "Sad");
    }
}
