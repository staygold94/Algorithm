import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1000 - Integer.parseInt(br.readLine());
        int answer = 0;

        answer += n / 500;
        n %= 500;

        answer += n / 100;
        n %= 100;

        answer += n / 50;
        n %= 50;

        answer += n / 10;
        n %= 10;

        answer += n / 5;
        n %= 5;

        answer += n / 1;
        n /= 1;

        System.out.println(answer);
    }
}