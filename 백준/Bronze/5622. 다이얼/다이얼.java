import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int answer = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= 'A' && ch <= 'R') {
                answer += (ch - 65) / 3 + 3;
            } else if(ch >= 'S' && ch <= 'Y') {
                answer += (ch - 66) / 3 + 3;
            } else if(ch == 'Z') {
                answer += 10;
            } else {
                answer += 11;
            }
        }
        System.out.println(answer);
    }
}