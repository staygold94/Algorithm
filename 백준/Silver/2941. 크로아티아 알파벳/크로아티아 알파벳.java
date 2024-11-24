import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String regex = "c=|c-|dz=|d-|lj|nj|s=|z=";

        s = s.replaceAll(regex, "X");

        System.out.println(s.length());
    }
}