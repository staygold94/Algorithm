import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char ch = '-';
        int answer = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(ch != s.charAt(i)) {
                ch = s.charAt(i);
                answer += 10;
            } else {
                answer += 5;
            }
        }
        System.out.println(answer);
    }
}