import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = -1;
        boolean[] primes = new boolean[10001];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for(int i=m; i<=n; i++) {
            if(!primes[i]) continue;
            if(isPrime(i)) {
                for(int j=i*2; j<=n; j+=i) {
                    primes[j] = false;
                }
            } else {
                primes[i] = false;
            }
        }

        for(int i=m; i<=n; i++) {
            if(primes[i]) {
                if(min == -1) min = i;
                sum += i;
            }
        }
        if(sum > 0) System.out.println(sum);
        System.out.println(min);
    }

    public static boolean isPrime(int num) {
        if(num == 1) return false;

        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
