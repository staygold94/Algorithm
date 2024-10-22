import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = Integer.MAX_VALUE;
        int num1 = n;
        int num2 = n;

        // 하나의 종류만 가져가기
        if(n % 5 == 0) answer = Math.min(answer, n/5);
        if(n % 3 == 0) answer = Math.min(answer, n/3);

        // 두 종류 가져가기
        while(num1 > 5) {
            int s = num1 % 5 + (n - num1);  // 현재 양에서 나머지 + 마이너스 하면서 빼둔 양
            if(s % 3 == 0) {
                answer = Math.min(answer, num1 / 5 + (s / 3));
            }
            num1 -= 5;
        }

        while(num2 > 3) {            
            int s = num2 % 3 + (n - num2);
            if(s % 5 == 0) {
                answer = Math.min(answer, num2 / 3 + (s / 5));
            }
            num2 -= 3;
        }
        
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}