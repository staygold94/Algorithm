import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String strA = st.nextToken();
        String strB = st.nextToken();


        BigInteger a = new BigInteger(strA);
        BigInteger b = new BigInteger(strB);
        System.out.println(a.add(b));
    }
}

