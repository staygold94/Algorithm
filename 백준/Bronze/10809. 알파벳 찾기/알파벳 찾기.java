import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] alpha = new int[26];

        Arrays.fill(alpha, -1);

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            alpha[ch - 'a'] = str.indexOf(ch);
        }

        for(int i=0; i<alpha.length; i++) {
            System.out.print(alpha[i] + " ");
        }
    }
}