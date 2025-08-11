import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            long num = Long.parseLong(br.readLine());
            while(true) {
                boolean isPrime = true;

                // 나눠 떨어지는 경우 소수가 아님
                for(int j=2; j<=Math.sqrt(num); j++) {
                    if(num % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                // 2 이하는 무조건 2가 나옴
                if(num <= 2) {
                    isPrime = true;
                    num = 2;
                }

                // 소수인 경우
                if(isPrime) {
                    sb.append(num + "\n");
                    break;
                }

                num++;
            }
        }
        System.out.print(sb.toString());
    }
}
