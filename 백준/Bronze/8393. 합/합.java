import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        int sum = (num + 1) * (num / 2);
        if(num % 2 != 0) sum += (num / 2) + 1;

        System.out.println(sum);
    }
}
