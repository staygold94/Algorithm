import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        if(str.equals("0")) {
            System.out.println(str);
            return;
        }

        for(int i=0; i<str.length(); i++) {
            int num = str.charAt(i) - '0';
            String trans = "";
            for(int j=2; j>=0; j--) {
                trans = num % 2 + trans;
                num /= 2;
            }
            sb.append(trans);
        }
        System.out.println(sb.toString().substring(sb.indexOf("1")));
    }
}
