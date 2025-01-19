import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        long sum = 0;
        long now = 1;
        long count = 0;

        while(sum < s) {
            sum += now;
            count++;
            now++;
        }

        if(s == sum) {
            System.out.println(count);
        } else {
            System.out.println(count - 1);
        }
    }
}