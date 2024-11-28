import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int num = 1;
        int count = 0;

        while(true) {
            if(count + num >= x) {
                break;
            }
            count += num;
            if(count < x) num++;
        }

        if (num % 2 == 1) {
            System.out.print((num + 1 -(x - count)) + "/" + (x - count));
        } else {
            System.out.print((x - count) + "/" + (num + 1 -(x - count)));
        }
    }
}
