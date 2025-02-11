import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        
        System.out.print(Integer.parseInt(a.replace('6', '5')) + Integer.parseInt(b.replace('6', '5')));
        System.out.print(" ");
        System.out.print(Integer.parseInt(a.replace('5', '6')) + Integer.parseInt(b.replace('5', '6')));
    }
}