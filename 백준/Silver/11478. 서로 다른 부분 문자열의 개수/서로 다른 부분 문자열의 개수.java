import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<s.length(); i++) {
            for(int j=1; i+j<=s.length(); j++) {
                set.add(s.substring(i, i+j));
            }
        }

        System.out.println(set.size());
    }
}