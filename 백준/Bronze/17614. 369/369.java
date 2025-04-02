import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++) {
            sb.append(i);
        }
        
        int total = sb.toString().length();
        int minus = sb.toString().replaceAll("3", "").replaceAll("6", "").replaceAll("9", "").length();
        System.out.print(total - minus);
    }
}
