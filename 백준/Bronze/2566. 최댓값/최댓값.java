import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = -1;
        int x = 0;
        int y = 0;

        for(int i=1; i<=9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num > max) {
                    max = num;
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(max);
        System.out.println(x + " " + y);
    }
}