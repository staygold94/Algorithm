import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n > 1) {
            for(int i=2; i<=n; i++) {
                if(n % i == 0 && isPrime(i)) {
                    System.out.println(i);
                    n /= i;
                    break;
                }
            }
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