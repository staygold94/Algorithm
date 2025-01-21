import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int zero = 0;
        int one = 0;

        for(int i=0; i<s.length(); i++) {
            for(int j=i+1; j<s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    i++;
                } else {
                    break;
                }
            }
            if(s.charAt(i) == '0') zero++;
            else one++;
        }
        System.out.println(Math.min(zero, one));
    }
}