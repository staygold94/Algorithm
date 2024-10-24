import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            int money = Integer.parseInt(br.readLine());
            int q, d, n, p;

            q = money / 25;
            money %= 25;

            d = money / 10;
            money %= 10;

            n = money / 5;
            money %= 5;

            p = money;

            System.out.println(q + " " + d + " " + n + " " + p);
        }
    }
}