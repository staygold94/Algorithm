import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = new int[26];
        String s = br.readLine().toLowerCase();

        for(int i=0; i<s.length(); i++) {
            int num = s.charAt(i) - 97;
            alpha[num]++;
        }

        int max = 0;
        char ch = '?';
        for(int i=0; i<26; i++) {
            if(max < alpha[i]) {
                max = alpha[i];
                ch = (char)(i+65);
            } else if(max == alpha[i]) {
                ch = '?';
            }
        }
        
        System.out.println(ch);
    }
}