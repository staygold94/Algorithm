import java.io.*;

public class Main {
    public static int max = 1000000;
    public static boolean[] primes;	// key. 소수를 배열에 표시하는 방법!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        primes = new boolean[max + 1];

        // 소수 배열 준비
        makePrimes();

        while(true) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) break;
            
            for(int i=num-3; i>=num/2; i-=2) {
                if(primes[i] && primes[num - i]) {
                    System.out.println(num + " = " + (num - i) + " + " + i);
                    break;
                }
            }
        }
    }

    public static void makePrimes() {

        for(int i=3; i<=max; i++) {
            if(isPrime(i)) primes[i] = true;
        }
    }

    public static boolean isPrime(int num) {

        if(num == 1) return false;

        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }

        return true;
    }
}