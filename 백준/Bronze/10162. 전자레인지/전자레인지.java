import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 0;
        int c = 0;

        a = n / 300;
        n -= a * 300;
        b = n / 60;
        n -= b * 60;
        c = n / 10;
        n -= c * 10;

        System.out.println(n > 0 ? -1 : (a + " " + b + " " + c));
    }
}