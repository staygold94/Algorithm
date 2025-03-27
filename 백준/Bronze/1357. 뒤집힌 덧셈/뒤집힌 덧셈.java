import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String x = st.nextToken();
        String y = st.nextToken();


        int sum = Rev(x) + Rev(y);
        String tmp = String.valueOf(sum);
        System.out.println(Rev(tmp));
    }

    public static int Rev(String s) {
        StringBuilder sb = new StringBuilder();
        return Integer.parseInt(sb.append(s).reverse().toString());
    }
}