import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isPrime = new boolean[1000001];
        Arrays.fill(isPrime, true);

        // 0, 1은 소수가 아님
        isPrime[0] = false;
        isPrime[1] = false;

        // 소수 구하기
        for(int i=2; i*i<=1000000; i++) {
            if(isPrime[i]) {
                for(int j=i*i; j<=1000000; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        for(int i=0; i<num; i++) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;    // 골드바흐 파티션의 갯수

            // 소수로 만들 수 있는 조합 카운팅
            for(int j=n-2; j>=n/2; j--) {
                if(isPrime[j] && isPrime[n-j]) cnt++;
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb.toString());
    }
}