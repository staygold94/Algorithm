import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = makePrimes(n);

        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = 0;

        while(right < arr.length) {
            sum += arr[right];

            while(sum > n && left <= right) {
                sum -= arr[left];
                left++;
            }

            if(sum == n) {
                answer++;
            }

            right++;
        }
        System.out.println(answer);
    }

    public static int[] makePrimes(int n) {

        List<Integer> list = new ArrayList<>();
        for(int i=2; i<=n; i++) {
            if(isPrime(i)) list.add(i);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static boolean isPrime(int n) {

        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}