import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<str.length(); i++) {
            int ch = str.charAt(i);

            if(ch >= 'a' && ch <= 'z') {
                ch -= 'a';
                ch += 13;
                ch %= 26;
                ch += 'a';
            } else if(ch >= 'A' && ch <= 'Z') {
                ch -= 'A';
                ch += 13;
                ch %= 26;
                ch += 'A';
            }
            sb.append((char)ch);
        }
        System.out.println(sb.toString());
    }
}