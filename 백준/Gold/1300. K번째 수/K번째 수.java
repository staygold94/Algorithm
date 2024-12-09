import java.io.*;

public class Main {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long left = 1;
        long right = k;
        long answer = 0;

        while(left <= right) {
            long mid = (left + right) / 2;
            long cnt = count(mid);

            if(cnt < k) {
                left = mid + 1;

            } else {
                right = mid - 1;
                answer = mid;
            }

        }

        System.out.println(answer);
    }

    public static long count(long num) {

        long cnt = 0;

        for(int i=1; i<=n; i++) {
            cnt += Math.min(num/i, n);
        }

        return cnt;
    }
}