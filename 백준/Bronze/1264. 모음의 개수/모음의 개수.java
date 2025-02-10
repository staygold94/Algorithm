import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder sb = new StringBuilder();
        while(true) {
            s = br.readLine();
            if(s.equals("#")) break;
            s = s.toLowerCase();

            int cnt = 0;
            for(int i=0; i<s.length(); i++) {
                char ch = s.charAt(i);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') cnt++;
            }
            sb.append(cnt + "\n");
        }
        System.out.print(sb.toString());
    }
}