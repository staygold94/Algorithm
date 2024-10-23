import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int number = 666;

        while(true) {
            if(String.valueOf(number).indexOf("666") > -1) cnt++;
            if(n == cnt) {
                System.out.println(number);
                break;
            }
            number++;
        }
    }
}