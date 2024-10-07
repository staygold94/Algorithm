import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        boolean isSame = true;

        for(int i=0; i<=str.length()/2; i++) {
            char a = str.charAt(i);
            char b = str.charAt(str.length() - i - 1);
            if(a != b) {
                isSame = false;
                break;
            }
        }

        System.out.println(isSame ? "1" : "0");
    }
}