import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){ 
            int num = s.charAt(i);
            if(num >= 65 && num <= 90) {
                num += 32;
            } else{
                num -= 32;
            }
            sb.append((char)num);
        }
        System.out.println(sb.toString());
    }
}