import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();        
        String[] arr = s.split(" ");
        System.out.println(s.equals("") ? 0 : arr.length);
    }
}