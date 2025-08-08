import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isPrime = new boolean[246913];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        // 소수 찾기
        for(int i=2; i*i <= 246913; i++) {
            if(isPrime[i]) {
                for(int j=i*i; j<=246913; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        int[] arr = new int[246913];
        for(int i=2; i<246913; i++) {
            arr[i] = arr[i-1];
            if(isPrime[i]) arr[i]++;
        }
        
        StringBuilder sb = new StringBuilder();
        while(true) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) break;

            sb.append((arr[num*2] - arr[num]) + "\n");
        }

        System.out.println(sb.toString());
    }
}
